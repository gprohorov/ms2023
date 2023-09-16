package edu.pro.ms2023.controller;

import edu.pro.ms2023.model.Musicant;
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
@RequestMapping("/api/v1/orchestra/")
public class OrchestraRestController {

    @Autowired
    OrchestraService service;

    @RequestMapping("hello")
    String sayHello(){
        return "<h1>hello</h1>";
    }

    @RequestMapping()
    List<Musicant> showAll(){
        return service.getAll();
    }

    @RequestMapping("{id}")
    Musicant showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("{id}")
    void deleteOne(@PathVariable String id) {
        // TODO
    }
    @PostMapping()
    Musicant create(@RequestBody Musicant mus) {
        return  service.create(mus);
    }
    @PutMapping()
    Musicant update(@RequestBody Musicant musicant) {
        return  null; // TODO
    }


}
