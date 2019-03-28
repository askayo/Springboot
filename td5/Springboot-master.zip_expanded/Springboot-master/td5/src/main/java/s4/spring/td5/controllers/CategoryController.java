package s4.spring.td5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import s4.spring.td5.entities.Category;
import s4.spring.td5.entities.User;
import s4.spring.td5.repositories.CategoryRepository;

@Controller
@RequestMapping("/category/")
public class CategoryController {
	@Autowired
	private CategoryRepository cateRep;
	
	@RequestMapping("create")
	@ResponseBody
	public String createUser() {
		Category cate= new Category();
		cate.setName("appli mobile");
		cateRep.save(cate);
		
		return cate.getName() +" ajouté dans la bdd.";
		
	}

}
