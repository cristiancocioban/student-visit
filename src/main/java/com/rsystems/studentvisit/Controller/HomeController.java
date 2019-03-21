package com.rsystems.studentvisit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping({"/"})
public class HomeController {
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public RedirectView index(Model model){
        return new RedirectView("/school");
    }
}
