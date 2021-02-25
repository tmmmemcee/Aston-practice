package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {

    List<ElementType> findAllElementTypeByElementTypeName(String elementTypeName);

    List<ElementType> findAllElementTypeByElementListContains(Element element);



}
