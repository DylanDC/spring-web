package com.formation.servlet.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formation.model.MessageDto;
import com.formation.validator.MessageValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ModelAndView adminInterfaceList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/list");
		return modelAndView;
	}

	@RequestMapping(value = "/messages/new", method = RequestMethod.GET)
	public ModelAndView adminNewMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", new MessageDto(null, null, null, null));
		modelAndView.setViewName("admin/create_message");
		return modelAndView;
	}

	@RequestMapping(value = "/messages/new", method = RequestMethod.POST)
	public String submit(@Validated @ModelAttribute("message") MessageDto message, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {

			return "admin/create_message";
		}

		return "admin/create_message";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new MessageValidator());
	}
}