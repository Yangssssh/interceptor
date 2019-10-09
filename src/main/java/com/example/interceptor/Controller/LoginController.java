package com.example.interceptor.Controller;

import com.example.interceptor.Entity.People;
import com.example.interceptor.Jpa.PeopleJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/people")
public class LoginController {

    @Autowired
    private PeopleJpa peopleJpa;

    @RequestMapping(value = "/login")
    public String login(People people, HttpServletRequest request){
        boolean flag=true;
        String result="登陆成功";
        Optional<People> p=peopleJpa.findOne(new Specification<People>() {
            @Override
            public Predicate toPredicate(Root<People> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        });
        if(p==null){
            flag=false;
            result="用户不存在，登陆失败";
            }else if(!p.get().getPassword().equals(people.getPassword())){
            flag=false;
            result="用户密码错误，登陆失败";
        }
        if(flag){
            request.getSession().setAttribute("session_people",p);
        }
        return result;
    }

//    @RequestMapping(value = "/find",method = RequestMethod.GET)
//    public People findpeople(String id,String name){
//        return peopleJpa.findByNameAndPassword(id, name);
//    }
}
