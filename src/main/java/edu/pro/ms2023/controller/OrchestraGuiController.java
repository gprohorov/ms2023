package edu.pro.ms2023.controller;

import edu.pro.ms2023.model.Musicant;
import edu.pro.ms2023.service.OrchestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   george
  @project   ms2023
  @class  OrchestraRestController
  @version  1.0.0 
  @since 11.09.23 - 11.56
*/
@Controller
@RequestMapping("/ui/v1/orchestra/")
public class OrchestraGuiController {

    @Autowired
    OrchestraService service;

    @RequestMapping()
    String showAll(Model model){
        List<Musicant> items = service.getAll();
        model.addAttribute("items", items);
        return "orchestra";
    }

    @RequestMapping("del/{id}")
    String deleteItem(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/ui/v1/orchestra/";
    }



}
