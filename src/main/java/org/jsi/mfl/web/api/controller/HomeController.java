package org.jsi.mfl.web.api.controller;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model){
		
		model.addAttribute("newOrgUnit", new OrganisationUnit());
		
		return "index";
	}
	
	@RequestMapping("/facilitysearch")
	public String myTemplate(){
		
		
		return "search";
	}
	
	@RequestMapping("/facility")
	public String facilityManagement(){
		
		
		return "facility";
	}
}
