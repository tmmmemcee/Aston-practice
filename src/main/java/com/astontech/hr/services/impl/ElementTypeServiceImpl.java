package com.astontech.hr.services.impl;

import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.astontech.hr.services.ElementTypeService;

@Service
public class ElementTypeServiceImpl implements ElementTypeService {

    @Autowired
    ElementTypeRepository elementTypeRepo;

    @Override
    public Iterable<ElementType> listAllElementType() {
        return elementTypeRepo.findAll();
    }

    @Override
    public ElementType getElementTypeById(Integer id) {
        return elementTypeRepo.findById(id).get();
    }

    @Override
    public ElementType saveElementType(ElementType elementType) {
        return elementTypeRepo.save(elementType);
    }

    @Override
    public Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypes) {
        return elementTypeRepo.saveAll(elementTypes);
    }

    @Override
    public void deleteElementType(Integer id) {
        elementTypeRepo.deleteById(id);
    }
}
