package edu.pro.ms2023.repository;

import edu.pro.ms2023.model.Musicant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
  @author   george
  @project   ms2023
  @class  MusRepository
  @version  1.0.0 
  @since 16.09.23 - 12.00
*/
@Repository
public interface MusRepository extends MongoRepository<Musicant, String> {
}
