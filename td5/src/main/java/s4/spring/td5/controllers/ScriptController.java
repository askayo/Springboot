package s4.spring.td5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td5.entities.Script;
import s4.spring.td5.repositories.CategoryRepository;
import s4.spring.td5.repositories.LanguageRepository;
import s4.spring.td5.repositories.ScriptRepository;
import s4.spring.td5.repositories.UserRepository;

@Controller
@RequestMapping("/script/")
public class ScriptController {
	
	@Autowired
	private ScriptRepository scrRep;

	
	@PostMapping("createScript")
	public RedirectView createScript(Script script) {
		scrRep.save(script);
		return new RedirectView("../user/index");
		
		
	}
	
	@GetMapping("new")
	public String newScript() {
		return "script/new";
	}
	
	

}
