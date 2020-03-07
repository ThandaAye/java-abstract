package com.thandaaye.javaabstract.service;

import com.thandaaye.javaabstract.entity.PagingDto;
import com.thandaaye.javaabstract.entity.Person;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class TeacherService extends PersonService {

    public PagingDto<Person> retrieveList(PagingDto pagingDto, boolean term) {
        return pagingDto;
    }

    @Override
    public boolean isValid(String searchType) {
        return "searchTeacher".equals(searchType);
    }
}
