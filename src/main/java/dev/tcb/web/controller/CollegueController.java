package dev.tcb.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.tcb.entite.Collegue;
import dev.tcb.repository.CollegueRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired CollegueRepository listeCollegue;
	
	@PostConstruct
	public void insererCollegue() {
		listeCollegue.save(new Collegue ("Toto le rigolo",100,"https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/LutraCanadensis_fullres.jpg/290px-LutraCanadensis_fullres.jpg"));
		listeCollegue.save(new Collegue("Popol le clown", 500, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Male_mallard_standing.jpg/220px-Male_mallard_standing.jpg"));
	}
	
	@GetMapping
	public List<Collegue> listerCollegue() {
		return this.listeCollegue.findAll();
	}
	
	@PostMapping
	public Collegue unCollegue(@RequestBody Collegue unCollegue) {
		
		return this.listeCollegue.save(unCollegue);
	}
	
	@PutMapping(value = "/{nom}")
	public Collegue editCollegue(@RequestBody Collegue editCollegue, @PathVariable String nom) {
		return this.listeCollegue.save(editCollegue);
	}
}
