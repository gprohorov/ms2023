package edu.pro.ms2023.service;

import edu.pro.ms2023.model.Orchestra;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
  @author   george
  @project   ms2023
  @class  OrchestraService
  @version  1.0.0 
  @since 11.09.23 - 12.03
*/
@Service
public class OrchestraService {
    private List<Orchestra> orchestras = new ArrayList<>();

    @PostConstruct
    void init(){
        orchestras.add(new Orchestra("1","John Lennon", "Beatles"));
        orchestras.add(new Orchestra("2","Freddie Mercury ", "Queen"));
        orchestras.add(new Orchestra("3","Tarja Turunen", "Nightwish"));
//
//        orchestras.add(new Orchestra("John Lennon", "Beatles"));
//        orchestras.add(new Orchestra("Freddie Mercury ", "Queen"));
//        orchestras.add(new Orchestra("Tarja Turunen", "Nightwish"));
//
    }

    public List<Orchestra> getAll(){
        return orchestras;
    }

    //READ
    public Orchestra get(String id) {
        return orchestras.stream().filter(el -> el.getId()
                .equals(id))
                .findFirst()
                .orElse(null);
    }

}
