package edu.pro.ms2023.service;

import edu.pro.ms2023.model.Musicant;
import edu.pro.ms2023.repository.MusRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    MusRepository repository;

  //  @PostConstruct
    void init() {
        orchestra.add(new Musicant("1","John Lennon", "Beatles"));
        orchestra.add(new Musicant("2","Freddie Mercury ", "Queen"));
        orchestra.add(new Musicant("3","Tarja Turunen", "Nightwish"));

//        orchestras.add(new Orchestra("John Lennon", "Beatles"));
//        orchestras.add(new Orchestra("Freddie Mercury ", "Queen"));
//        orchestras.add(new Orchestra("Tarja Turunen", "Nightwish"));
//
        repository.saveAll(orchestra);
    }

    public List<Musicant> getAll(){
        return repository.findAll();
    }

    //READ
    public Musicant get(String id) {
        return repository.findById(id).orElse(null);
    }

    public Musicant create(Musicant mus) {
        mus.setCreatedAt(LocalDateTime.now());
        return  repository.save(mus);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
