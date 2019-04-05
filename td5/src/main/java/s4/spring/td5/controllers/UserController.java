package s4.spring.td5.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td5.entities.Script;
import s4.spring.td5.entities.User;
import s4.spring.td5.repositories.ScriptRepository;
import s4.spring.td5.repositories.UserRepository;
	
	
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserRepository userRep;
	private ScriptRepository scrRep;
	
	@Autowired
	private ScriptRepository scriptRep;
	
	@RequestMapping("create")
	@ResponseBody
	public String createUser() {
		User user= new User();
		user.setEmail("test@hotmail.fr");
		user.setIdentity("test");
		user.setLogin("azerty");
		user.setPassword("123456");
		userRep.save(user);
		
		return user.getIdentity() +" ajouté dans la bdd.";
		
	}
	
	
	@RequestMapping("{path:index}")
	public String index(Model model,HttpSession session) {
		List<Script> script = scriptRep.findAll();
		model.addAttribute("users", session.getAttribute("user"));
		model.addAttribute("scripts",script);
		return"index";
	}
	
	
	@RequestMapping(value = "loguser")
	public RedirectView Login(Model model, @RequestParam(value= "username")String username,@RequestParam(value="mdp")String mdp, HttpSession session) {
		List<User> users = userRep.findAll();
		
		for(User logs : users) {
			if(logs.getLogin().equals(username)  && logs.getPassword().equals(mdp)) {
				session.setAttribute("user", logs );
				model.addAttribute("session",session.getAttribute("user"));
				return new RedirectView("index");
			}
		}
		
		return new RedirectView("logout");
	}
	
	
	@GetMapping({"","login"})
	public String loginView(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	

	@RequestMapping("logout")
	public String logout() {
	
		return "logout";
	}
	
	
	
	
	
	
	
	
	
	
}

