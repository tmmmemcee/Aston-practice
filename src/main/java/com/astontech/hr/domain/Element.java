package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ElementId")
    private Integer id;

    @Version
    private Integer version;

    private String elementName;

    //region CONSTRUCTORS
    public Element() {
    }

    public Element(String elementName) {
        this.elementName = elementName;
    }
    //endregion

    //region GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return id.equals(element.id) && version.equals(element.version) && elementName.equals(element.elementName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, elementName);
    }
}
