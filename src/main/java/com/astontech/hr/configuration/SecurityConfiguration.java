package com.astontech.hr.configuration;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.authentication.method}")
    private String authenticationMethod;
    @Value ("${spring.security.ldap.domain}")
    private String ldapDomain;
    @Value("${spring.security.ldap.url}")
    private String ldapUrl;

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configurationGlobal(AuthenticationManagerBuilder auth) throws Exception {
        if(authenticationMethod.equals("NONE")) {

        }else if(authenticationMethod.equals("IN_MEMORY")) {
            auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles(("USER"));
            auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles(("ADMIN"));
            auth.inMemoryAuthentication().withUser("dba").password("{noop}123").roles(("DBA"));
        } else if (authenticationMethod.equals("LDAP")) {
            auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
//
        } else if(authenticationMethod.equals("DATABASE")) {
            JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
            userDetailsManager.setDataSource(dataSource);
            PasswordEncoder encoder = new BCryptPasswordEncoder();
//
            auth.userDetailsService(userDetailsManager).passwordEncoder(encoder);
            auth.jdbcAuthentication().dataSource(dataSource);
//
            if (!userDetailsManager.userExists("user")) {
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("USER"));
                User userDetails = new User("user", encoder.encode("password"), authorities);
                userDetailsManager.createUser(userDetails);

            }
        }

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        if (authenticationMethod.equals("NONE")) {
            httpSecurity
                    .authorizeRequests().antMatchers("/").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/console/**").permitAll();
        }
        else if (authenticationMethod.equals("IN_MEMORY")) {

            httpSecurity
                    .authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .and()
                    .authorizeRequests().antMatchers("/console/**").access("hasRole('ROLE_DBA')");


        }else if (authenticationMethod.equals("LDAP")) {
            httpSecurity.authorizeRequests().antMatchers("/static/**").permitAll().and()
                    .authorizeRequests().antMatchers("/login**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
        } else if (authenticationMethod.equals("DATABASE")) {
            httpSecurity.authorizeRequests().antMatchers("/static/**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/login**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/admin/**").hasAuthority("USER");
        }
        httpSecurity.formLogin().loginPage("/login").loginProcessingUrl("/login.do")
                .defaultSuccessUrl("/",true).failureUrl("/login?err=1")
                .usernameParameter("username").passwordParameter("password");
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
//
    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider authenticationProvider =
                new ActiveDirectoryLdapAuthenticationProvider(ldapDomain, ldapUrl);
        authenticationProvider.setConvertSubErrorCodesToExceptions(true);
        authenticationProvider.setUseAuthenticationRequestCredentials(true);
        return authenticationProvider;
    }
}
