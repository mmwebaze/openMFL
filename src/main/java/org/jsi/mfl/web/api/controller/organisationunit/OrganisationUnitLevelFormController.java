package org.jsi.mfl.web.api.controller.organisationunit;

import javax.annotation.Resource;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitLevelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrganisationUnitLevelFormController {

	@Resource
	private OrganisationUnitLevelService organisationUnitLevelService;
	
	@RequestMapping(value="/addOrgUnitLevel", method=RequestMethod.GET)
	public String addOrganisationUnitLevelForm(Model model){
	
		model.addAttribute("orgUnitLevel", new OrganisationUnitLevel());
		return "manageLevels";
	}
	
	@RequestMapping(value="/submitOrgUnitLevel", method=RequestMethod.POST)
	public String addOrganisationUnit(@ModelAttribute OrganisationUnitLevel orgUnitLevel){
		
		organisationUnitLevelService.addOrganisationUnitLevel(orgUnitLevel);
		return "redirect:/addOrgUnitLevel";
	}
}
