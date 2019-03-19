package s4.spring.td5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	
	
}

