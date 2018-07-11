package com.DrugSearch.www.drugsearch.Controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DrugSearch.www.drugsearch.Models.Drug;
import com.DrugSearch.www.drugsearch.Repositories.DrugsRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DrugsController{
	
	@Autowired
	private DrugsRepository drugsRepository;
	@Autowired
	//private MechanismsRepository mech;

	
	@GetMapping("/drugs")
	public MappingJacksonValue retrieveSomeBean() {
		List<Drug> drugs = drugsRepository.findAll();

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("drugs");

		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(drugs);

		mapping.setFilters(filters);

		return mapping;
	}
	@GetMapping("/drugs/{id}")
	public MappingJacksonValue getDrugById(@PathVariable int id) {
		//Drug drug=drugsRepository.findById(id).get();
		Optional<Drug> drug=drugsRepository.findById(id);
		if(!drug.isPresent()) {
			throw new DrugNotFoundException("id-"+id);
		}
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("drugs");

		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(drug);

		mapping.setFilters(filters);
		return mapping;
	}
	@GetMapping("/drugs/id")
	public MappingJacksonValue getDrugByIdParams(@RequestParam("id") int id) {
		//Drug drug=drugsRepository.findById(id).get();
		Optional<Drug> drug=drugsRepository.findById(id);
		if(!drug.isPresent()) {
			throw new DrugNotFoundException("id-"+id);
		}
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("drugs");

		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(drug);

		mapping.setFilters(filters);
		return mapping;
	}
	
	@PostMapping("/drugs")
	public ResponseEntity<Object> addDrug(@Valid @RequestBody Drug drug){
		Drug d=drugsRepository.save(drug);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(d.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	

}
