package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.ContactVO;
import com.astontech.hr.domain.VO.ElementVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @RequestMapping(value = "/contact")
    public String contactPage(Model model) {
        model.addAttribute("contactVO", new ContactVO());
        return "contact";
    }
}

