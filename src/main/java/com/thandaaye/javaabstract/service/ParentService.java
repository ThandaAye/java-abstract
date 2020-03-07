package com.thandaaye.javaabstract.service;

import com.thandaaye.javaabstract.entity.PagingDto;
import com.thandaaye.javaabstract.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class ParentService extends PersonService {

    public PagingDto<Person> retrieveList(PagingDto pagingDto, boolean term) {
        return pagingDto;
    }

    @Override
    public boolean isValid(String searchType) {
        return "searchParent".equals(searchType);
    }
}
