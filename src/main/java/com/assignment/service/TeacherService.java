/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.service;


import com.assignment.entities.Teacher;
import com.assignment.repository.TeacherRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nasos
 */
@Service
@Transactional
public class TeacherService {
        @Autowired
    private TeacherRepository repo;
     
    public List<Teacher> listAll() {
        return repo.findAll();
    }
     
    public void save(Teacher teacher) {
        repo.save(teacher);
    }
     
    public Teacher get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
}
