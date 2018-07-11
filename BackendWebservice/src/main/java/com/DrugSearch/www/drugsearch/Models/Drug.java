package com.DrugSearch.www.drugsearch.Models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@JsonFilter("BeanFilter")
public class Drug extends SearchItem {
	
	@ManyToMany(fetch = FetchType.EAGER,//failed to lazily intialize
			cascade= {
			CascadeType.PERSIST	})
	private Set<Mechanism> mechanisms=new HashSet<>();
	public Set<Mechanism> getMechanisms() {
		return mechanisms;
	}
	public void setMechanisms(Set<Mechanism> mechanisms) {
		this.mechanisms = mechanisms;
	}
	
	
	
	
}
