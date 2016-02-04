package org.jsi.mfl.web.api.controller.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchFormController {
	@Resource
	private OrganisationUnitTypeService organisationUnitTypeService;
	
	@RequestMapping("/facilitysearch")
	public String search(Model model){
		List<OrganisationUnitType> orgUnitTypes = organisationUnitTypeService.getOrganisationUnitTypes();
		model.addAttribute("orgUnitTypes", orgUnitTypes);
		
		return "search";
	}
}
