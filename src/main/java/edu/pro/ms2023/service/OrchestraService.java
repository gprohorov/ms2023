package edu.pro.ms2023.service;

import edu.pro.ms2023.model.Musicant;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
  @author   george
  @project   ms2023
  @class  OrchestraService
  @version  1.0.0 
  @since 11.09.23 - 12.03
*/
@Service
public class OrchestraService {
    private List<Musicant> orchestra = new ArrayList<>();

    @PostConstruct
    void init(){
        orchestra.add(new Musicant("1","John Lennon", "Beatles"));
        orchestra.add(new Musicant("2","Freddie Mercury ", "Queen"));
        orchestra.add(new Musicant("3","Tarja Turunen", "Nightwish"));

//        orchestras.add(new Orchestra("John Lennon", "Beatles"));
//        orchestras.add(new Orchestra("Freddie Mercury ", "Queen"));
//        orchestras.add(new Orchestra("Tarja Turunen", "Nightwish"));
//
    }

    public List<Musicant> getAll(){
        return orchestra;
    }

    //READ
    public Musicant get(String id) {
        return orchestra.stream().filter(el -> el.getId()
                .equals(id))
                .findFirst()
                .orElse(null);
    }

    public Musicant create(Musicant mus) {
        mus.setId(UUID.randomUUID().toString());
        mus.setCreatedAt(LocalDateTime.now());
        orchestra.add(mus);
        return  mus;
    }
}
