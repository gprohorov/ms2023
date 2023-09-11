package edu.pro.ms2023.controller;

import edu.pro.ms2023.model.Orchestra;
import edu.pro.ms2023.service.OrchestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   george
  @project   ms2023
  @class  OrchestraRestController
  @version  1.0.0 
  @since 11.09.23 - 11.56
*/
@RestController
@RequestMapping("/api/v1/orchestras/")
public class OrchestraRestController {

    @Autowired
    OrchestraService service;

    @RequestMapping("hello")
    String sayHello(){
        return "<h1>hello</h1>";
    }

    @RequestMapping()
    List<Orchestra> showAll(){
        return service.getAll();
    }

    @RequestMapping("{id}")
    Orchestra showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("{id}")
    void deleteOne(@PathVariable String id) {
        // TODO
    }
    @PostMapping()
    Orchestra create(@RequestBody Orchestra orchestra) {
        return  null; // TODO
    }
    @PutMapping()
    Orchestra update(@RequestBody Orchestra orchestra) {
        return  null; // TODO
    }


}
