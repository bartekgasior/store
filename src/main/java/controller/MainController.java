package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.PurchaseService;
import service.UserService;

@Controller
public class MainController {

	@Autowired
	PurchaseService purchaseService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"/login" ,"/"} , method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout,
						@RequestParam(value = "registered", required = false) String registered,
						@RequestParam(value = "usernameExists", required = false) String usernameExists,
						Model model) {
		String errorMessage = null;
		String logoutMessage = null;
		String registeredMessage = null;
		String usernameMessage = null;
		if(error != null) {
			errorMessage = "Incorect username or password";
		}
		if(logout != null) {
			logoutMessage = "Logout confirmed";
		}
		if(registered != null) {
			registeredMessage = "Successfully registered";
		}
		if(usernameExists != null) {
			usernameMessage = "Username is already in database";
		}
		model.addAttribute("errorMessage", errorMessage);
		model.addAttribute("logoutMessage", logoutMessage);
		model.addAttribute("registeredMessage", registeredMessage);
		model.addAttribute("usernameMessage", usernameMessage);
		return "login";
	}
	
	@RequestMapping(value = "/admin")
	public String adminLogin(Model model){
		return "adminViews/adminLogin";
	}
	
	@RequestMapping(value = "/Access_Denied")
	public String accessDenied(Model model) {
		return "accessDenied";
	}
	
	@RequestMapping(value = "/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String proceedRegister(@ModelAttribute("user") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "register";
		}
		if(checkIfUserExists(user.getName())) {
			return "redirect:login?usernameExists=true";
		}
		//----check if user exists
		
		userService.addUser(user);
		return "redirect:login?registered=true";
	}
	
	private boolean checkIfUserExists(String username) {
		List<User> allUsers = userService.getAllUsers();
		for(int i=0;i<allUsers.size();i++) {
			if(allUsers.get(i).getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
