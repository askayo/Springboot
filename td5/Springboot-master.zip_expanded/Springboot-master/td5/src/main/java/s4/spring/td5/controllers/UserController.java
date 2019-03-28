package s4.spring.td5.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td5.entities.User;
import s4.spring.td5.repositories.UserRepository;
	
	
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserRepository userRep;
	
	@RequestMapping("create")
	@ResponseBody
	public String createUser() {
		User user= new User();
		user.setEmail("test@hotmail.fr");
		user.setIdentity("test");
		user.setLogin("test");
		user.setPassword("mdp");
		userRep.save(user);
		
		return user.getIdentity() +" ajouté dans la bdd.";
		
	}
	
	
	@RequestMapping("{path:index}")
	public String index(Model model) {
		List<User> users = userRep.findAll();
		model.addAttribute("users", users);
		return"index";
	}
	
	
	@PostMapping("login")
	public RedirectView Login(Model model, User user, HttpSession session) {
		userRep.findAll();
		
		return new RedirectView("/login");
	}
	
	
	@GetMapping("login")
	public String loginView(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	

	@RequestMapping("logout")
	public String logout() {
	
		return "logout";
	}
	
	
	
	
	
	
	
	
}

