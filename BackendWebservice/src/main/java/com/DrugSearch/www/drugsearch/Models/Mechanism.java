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
public class Mechanism extends SearchItem {
	

	@ManyToMany(fetch = FetchType.EAGER,
			cascade= {
					CascadeType.PERSIST	},mappedBy="mechanisms")
	private Set<Drug> drugs=new HashSet<>();

	public Set<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Set<Drug> drugs) {
		this.drugs = drugs;
	}


	

	
	
}
