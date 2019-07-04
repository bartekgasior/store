package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users")
	public String users(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "adminViews/users";
	}
	
	@RequestMapping(value = "/users/edit")
	public String editUser(@RequestParam("id") int id, Model model) {
		User user = userService.getUserByID(id);
		model.addAttribute("user", user);
		return "adminViews/editUser";
	}
	
	@RequestMapping(value = "/users/edit", method = RequestMethod.POST)
	public String processEditUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "adminViews/editUser";
		}
		userService.update(user);
		return "redirect:/admin/users";
	}
	
	@RequestMapping(value = "/users/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/admin/users";
	}
}
