package s4.spring.td5.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td5.entities.History;
import s4.spring.td5.entities.Script;
import s4.spring.td5.repositories.CategoryRepository;
import s4.spring.td5.repositories.HistoryRepository;
import s4.spring.td5.repositories.LanguageRepository;
import s4.spring.td5.repositories.ScriptRepository;
import s4.spring.td5.repositories.UserRepository;

@Controller

public class ScriptController {
	
	@Autowired
	private ScriptRepository scrRep;
	private HistoryRepository historyRepo;
	
	@PostMapping("/script/createScript")
	public RedirectView createScript(Script script) {
		scrRep.save(script);
		return new RedirectView("../user/index");
		
		
	}
	
	@GetMapping("/script/new")
	public String newScript() {
		return "script/new";
	}
	
	@GetMapping("user/script/{id}/delete")
	public RedirectView deleteScript(@PathVariable("id") int id, ModelMap model) {
			scrRep.deleteById(id);
			return new RedirectView("../../index");

	}
	

	

}
