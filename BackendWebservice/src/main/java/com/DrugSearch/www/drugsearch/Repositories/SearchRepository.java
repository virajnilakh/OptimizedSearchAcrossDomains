package com.DrugSearch.www.drugsearch.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DrugSearch.www.drugsearch.Models.SearchItem;
@Repository
public interface SearchRepository extends JpaRepository<SearchItem,Integer>{
	List<SearchItem> findByNameContainingIgnoreCase(String searchString);
}
