package com.thandaaye.javaabstract.controller;

import com.thandaaye.javaabstract.entity.PagingDto;
import com.thandaaye.javaabstract.entity.Person;
import com.thandaaye.javaabstract.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class CommonController extends AbstractController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = {"/common/{searchType}"}, method = RequestMethod.GET)
    public @ResponseBody Object searchTeacher(@RequestParam(value = "term") String term, @PathVariable String searchType)
            throws Exception {
        PersonService service = null;

        Map<String, PersonService> services = context.getBeansOfType(PersonService.class);

        for (String key: services.keySet()) {
            PersonService tmp = services.get(key);
            if (tmp.isValid(searchType)) {
                service = tmp;
            }
        }

        if (service != null) {
            PagingDto<Person> pagingDto = new PagingDto();
            pagingDto.setResultsPerPage(null);
            pagingDto.setSearch(term);

            List<Person> people = service.retrieveList(pagingDto, false).getResults();

            List<Map<String, String>> ret = new ArrayList<>();
            for (Person person : people) {
                Map<String, String> res = new HashMap<>();
                res.put("label", person.getLabel());
                res.put("value", person.getId());
                ret.add(res);
            }
            return ret;
        }

        return Collections.emptyList();
    }
}
