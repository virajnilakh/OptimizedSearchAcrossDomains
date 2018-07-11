package com.DrugSearch.www.drugsearch.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DrugSearch.www.drugsearch.Models.Drug;
import com.DrugSearch.www.drugsearch.Models.Mechanism;
import com.DrugSearch.www.drugsearch.Repositories.MechanismsRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class MechanismsController {
	
	@Autowired
	private MechanismsRepository mechanismsRepository;
	
	@GetMapping("/mechanisms")
	public MappingJacksonValue getAllMechanism(){
		List<Mechanism> mechanisms=mechanismsRepository.findAll();
		MappingJacksonValue mapping=new MappingJacksonValue(mechanisms);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.serializeAllExcept("mechanisms");
		FilterProvider filters=new SimpleFilterProvider().addFilter("BeanFilter",filter);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/mechanisms/{id}")
	public MappingJacksonValue getMechanism(@PathVariable int id) {
		Optional<Mechanism> mechanism=mechanismsRepository.findById(id);
		if(!mechanism.isPresent()) {
			throw new MechanismNotFoundException("id-"+id);
		}
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("mechanisms");

		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(mechanism);

		mapping.setFilters(filters);
		return mapping;

	}
}
