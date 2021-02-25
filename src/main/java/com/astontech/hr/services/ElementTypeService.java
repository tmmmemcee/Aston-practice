package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

public interface ElementTypeService {

    Iterable<ElementType> listAllElementType();
    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypes);

    void deleteElementType(Integer id);

}
