package com.thandaaye.javaabstract.service;

import com.thandaaye.javaabstract.entity.PagingDto;
import com.thandaaye.javaabstract.entity.Person;

public abstract class PersonService {

    public abstract PagingDto<Person> retrieveList(PagingDto pagingDto, boolean term);

    public abstract boolean isValid(String searchType);
}
