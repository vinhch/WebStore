package com.vinhomn.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.vinhomn.data.domain.User;
import com.vinhomn.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index() {
		return "admin/index";
	}

	@RequestMapping(value = "/admin/signin", method = RequestMethod.GET)
	public String signIn() {
		return "admin/signin";
	}
	
	@RequestMapping(value = "/admin/signup", method = RequestMethod.GET)
	public String signUp(Model model, HttpServletRequest request) {
		model.addAttribute("user", new User());
		model.addAttribute("ipAddress", request.getRemoteAddr());
		
		return "admin/signup";
	}
	
	@RequestMapping(value = "/admin/signup", method = RequestMethod.POST)
	public String signUp(@Valid User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "admin/signup";
		}
		
		try {
			userService.createNewUserAccount(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:admin/signin";
	}
}
