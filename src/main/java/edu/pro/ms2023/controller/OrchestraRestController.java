package edu.pro.ms2023.controller;

import edu.pro.ms2023.model.Musicant;
import edu.pro.ms2023.service.OrchestraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = " Контролер Оркестру", description = " Повний КРУД")
public class OrchestraRestController {


    private final OrchestraService service;
    @Autowired
    public OrchestraRestController(OrchestraService service) {
        this.service = service;
    }

    @RequestMapping("hello")
    String sayHello(){
        return "<h1>hello</h1>";
    }

    @RequestMapping()
    List<Musicant> showAll(){
        return service.getAll();
    }

    @Operation(summary = " Пошук музиканта по ай-ді", description = " Повертає об'єкт"  )
    @RequestMapping("{id}")
    Musicant showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("{id}")
    void deleteOne(@PathVariable String id) {
        service.get(id);
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
