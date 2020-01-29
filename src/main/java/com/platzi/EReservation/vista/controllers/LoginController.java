package com.platzi.EReservation.vista.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador de login
 * @author yojan
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {
	
	@GetMapping(value = {"/login", "/"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		String errorMessage="Usuario no autorizado, debe autenticarse";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("login");
		return mav;
	}
	
	@GetMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
