package com.DrugSearch.www.drugsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.DrugSearch.www.drugsearch.Models.Drug;
import com.DrugSearch.www.drugsearch.Models.Mechanism;
import com.DrugSearch.www.drugsearch.Models.SearchItem;
import com.DrugSearch.www.drugsearch.Repositories.DrugsRepository;
import com.DrugSearch.www.drugsearch.Repositories.MechanismsRepository;
import com.DrugSearch.www.drugsearch.Repositories.SearchRepository;


@Component	
public class SearchDrugCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private DrugsRepository drugs;
	@Autowired
	private SearchRepository items;
	@Autowired
	private MechanismsRepository mechanisms;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SearchItem s1=new Drug();
		s1.setName("GluforminXL");
		s1.setType("DRUG");
		SearchItem s2=new Mechanism();
		s2.setName("Topoisomerase");
		s2.setType("MECH");
		items.save(s1);
		items.save(s2);
		SearchItem s3=new Drug();
		s3.setName("Temozolomide");
		s3.setType("DRUG");
		SearchItem s4=new Mechanism();
		s4.setName("DNA Topoisomerase II alpha Inhibitors");
		s4.setType("MECH");
		items.save(s3);
		items.save(s4);
		SearchItem s5=new Mechanism();
		s5.setName("DNA Alkylating Drugs");
		s5.setType("MECH");
		items.save(s5);
		SearchItem s6=new Mechanism();
		s6.setName("TEP II Inhibitors");
		s6.setType("MECH");
		items.save(s6);
		
		Drug d1=drugs.findById(s1.getId()).get();//this wasnt working, so did items save beforehand
		Mechanism m1=mechanisms.findById(s2.getId()).get();
		d1.getMechanisms().add(m1);
		m1.getDrugs().add(d1);
		drugs.save(d1);//Added because mech in drug was getting blank
		
		Drug d2=drugs.findById(s3.getId()).get();//this wasnt working, so did items save beforehand
		Mechanism m2=mechanisms.findById(s4.getId()).get();
		d2.getMechanisms().add(m2);
		d2.getMechanisms().add(m1);
		m1.getDrugs().add(d2);
		m2.getDrugs().add(d2);
		drugs.save(d2);
		
		
	}

}
