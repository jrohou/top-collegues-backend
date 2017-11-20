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
		listeCollegue.save(new Collegue ("Toto le rigolo",100,"http://www.coloori.com/wp-content/uploads/2016/05/loutrefond.jpg"));
		listeCollegue.save(new Collegue("Popol le clown", 500, "https://www.ciwf.fr/media/7431059/fr-wide-july-17.jpg"));
	}
	
	@GetMapping
	public List<Collegue> listerCollegue() {
		return this.listeCollegue.findAll();
	}
	
	@PostMapping
	public Collegue unCollegue(@RequestBody Collegue unCollegue) {
		
		return this.listeCollegue.save(unCollegue);
	}
	
	@PutMapping(value = "/{nom}/score")
	public Collegue editCollegue(@RequestBody Collegue editCollegue, @PathVariable String nom) {
		return this.listeCollegue.save(editCollegue);
	}
}
