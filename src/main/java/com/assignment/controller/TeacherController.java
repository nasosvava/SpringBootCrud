package com.assignment.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.assignment.entities.Teacher;
import com.assignment.service.TeacherService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nasos
 */
@Controller
public class TeacherController {
 @Autowired
    private TeacherService service ; 
 
 
 @RequestMapping("/")
public String viewHomePage(Model model) {
    List<Teacher> listTeachers = service.listAll();
    model.addAttribute("listTeachers", listTeachers);
     
    return "index";
}

@RequestMapping("/new")
public String showNewTeacherPage(Model model) {
    Teacher teacher = new Teacher();
    model.addAttribute("teacher", teacher);
     
    return "new_teacher";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveTeacher(@Valid @ModelAttribute("teacher") Teacher teacher,BindingResult result) {
            if (result.hasErrors()) {
            return "new_teacher";
        }
    service.save(teacher);
    return "redirect:/";
}

@RequestMapping("/edit/{id}")
public ModelAndView showEditTeacherPage(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("edit_teacher");
     Teacher teacher = service.get(id);
    mav.addObject("teacher", teacher);
     
    return mav;
}

@RequestMapping("/delete/{id}")
public String deleteTeacher(@PathVariable(name = "id") int id) {
    service.delete(id);
    return "redirect:/";       
}

}

