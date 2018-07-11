package com.DrugSearch.www.drugsearch.Models;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.apache.catalina.User;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@JsonFilter("BeanFilter")//added to the controller because of some problem with bean filter
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class SearchItem {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	public String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
