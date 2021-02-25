package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

public interface ElementService {

    Iterable<Element> listAllElements();
    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elements);

    void deleteElement(Integer id);
}
