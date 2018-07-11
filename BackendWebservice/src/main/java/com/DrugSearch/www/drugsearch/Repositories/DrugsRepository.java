package com.DrugSearch.www.drugsearch.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DrugSearch.www.drugsearch.Models.Drug;
@Repository
public interface DrugsRepository extends JpaRepository<Drug,Integer> {

}
