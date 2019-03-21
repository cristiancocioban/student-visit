package com.rsystems.studentvisit.Controller;

import com.rsystems.studentvisit.Model.School;
import com.rsystems.studentvisit.Repository.SchoolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping({"/school"})
public class SchoolController {
    @Autowired
    SchoolRepository schoolRepository;
    Logger logger = LoggerFactory.getLogger(SchoolController.class);


    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String readAll(Model model){
        model.addAttribute("schools", schoolRepository.findAll());
        return "schools";
    }

    @PostMapping("/create")
    public RedirectView create(@Valid School school, BindingResult result) {

        if (result.hasErrors()) {
            return new RedirectView("/school/create");
        }
        school.setId(UUID.randomUUID().toString());
        schoolRepository.save(school);
        return new RedirectView("/school");
    }

    @GetMapping("/create")
    public String showCreateSchoolForm(School school) {
        return "create-school";
    }

    @PostMapping("/update/{id}")
    public RedirectView update(@PathVariable("id") String id, @Valid School school,
                                         BindingResult result) {
        logger.error("here1");
        if (result.hasErrors()) {
            logger.error("here");
            logger.error(result.toString());
            school.setId(id);
            return new RedirectView("/school/edit/"+id);
        }

        schoolRepository.save(school);
        return new RedirectView("/school");
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("school", school);
        return "update-school";
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteUser(@PathVariable("id") String id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid school Id:" + id));
        schoolRepository.delete(school);
        return new RedirectView("/school");
    }
}
