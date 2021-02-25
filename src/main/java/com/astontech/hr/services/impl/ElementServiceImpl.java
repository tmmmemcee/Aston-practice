package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.astontech.hr.services.ElementService;


@Service
public class ElementServiceImpl implements ElementService {


    @Autowired
    ElementRepository elementRepo;


    @Override
    public Iterable<Element> listAllElements() {
        return elementRepo.findAll();
    }

    @Override
    public Element getElementById(Integer id) {
        return elementRepo.findById(id).get();
    }

    @Override
    public Element saveElement(Element element) {
        return elementRepo.save(element);
    }

    @Override
    public Iterable<Element> saveElementList(Iterable<Element> elements) {
        return elementRepo.saveAll(elements);
    }

    @Override
    public void deleteElement(Integer id) {
        elementRepo.deleteById(id);
    }
}
