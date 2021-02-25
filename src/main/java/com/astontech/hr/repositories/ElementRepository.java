package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementRepository extends CrudRepository<Element, Integer> {
    Element findByElementName(String elementName);
    Element findByElementNameIgnoreCase(String elementName);

    long countByElementName(String elementName);

    List<Element> findAllByElementNameContains(String elementName);



}
