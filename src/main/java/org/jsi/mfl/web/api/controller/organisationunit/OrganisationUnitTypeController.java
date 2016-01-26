package org.jsi.mfl.web.api.controller.organisationunit;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitTypeService;
import org.jsi.mfl.api.service.servicetype.ServiceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrganisationUnitTypeController {
	
	@Resource
	private OrganisationUnitTypeService orgUnitTypeService;
	@RequestMapping(value="/orgunittypemanagement", method=RequestMethod.GET)
	public String orgUnitTypeManagementView(Model model){
		List<OrganisationUnitType> orgUnitTypes = orgUnitTypeService.getOrganisationUnitTypes();
		model.addAttribute("orgUnitTypes", orgUnitTypes);
		return "orgunittypemanagement";
	}
	
	@RequestMapping(value="/addOrgUnitType", method=RequestMethod.GET)
	public String addOrganisationUnitTypeForm(Model model){
		model.addAttribute("orgUnitType", new OrganisationUnitType());
		return "addOrgUnitType";
	}
	@RequestMapping(value="/submitOrgUnitType", method=RequestMethod.POST)
	public String addOrganisationUnitType(@ModelAttribute(value="orgUnitType") @Valid OrganisationUnitType orgUnitType){
		//System.out.println(orgUnitType);
		
		orgUnitTypeService.addOrganisationUnitType(orgUnitType);
		return "redirect:/addOrgUnitType";
	}

}
