package com.example.interceptor.Jpa;

import com.example.interceptor.Entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;

@Transactional
public interface PeopleJpa extends JpaRepository<People,Long>, JpaSpecificationExecutor<People> {

    People findByNameAndPassword(String name,String id);
}
