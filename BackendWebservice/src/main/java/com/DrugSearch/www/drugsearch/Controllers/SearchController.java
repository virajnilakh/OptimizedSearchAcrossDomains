package com.DrugSearch.www.drugsearch.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DrugSearch.www.drugsearch.Models.SearchItem;
import com.DrugSearch.www.drugsearch.Repositories.SearchRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class SearchController {
	@Autowired
	private SearchRepository search;
	@GetMapping("/search/{searchString}")
	public MappingJacksonValue getSearchItems(@PathVariable String searchString){
		//List<SearchItem> items=search.findAll();
		List<SearchItem> items=search.findByNameContainingIgnoreCase(searchString);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.serializeAllExcept("drugs","mechanisms");
		FilterProvider filters=new SimpleFilterProvider().addFilter("BeanFilter", filter);

		MappingJacksonValue mapping=new MappingJacksonValue(items);
		mapping.setFilters(filters);
		return mapping;
	}
}
