package org.jsi.mfl.web.api.controller.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitLevelService;
import org.jsi.mfl.api.service.servicetype.ServiceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrganisationUnitFormController {

	@Resource
	private OrganisationUnitLevelService organisationUnitLevelService;
	@Resource
	private ServiceTypeService serviceTypeService;
	
	@RequestMapping(value="/addOrgUnit", method=RequestMethod.GET)
	public String addOrganisationUnitForm(Model model){
		List<OrganisationUnitLevel> orgUnitLevels = organisationUnitLevelService.getOrganisationUnitLevels();
		List<ServiceType> servicesTypes = serviceTypeService.getServiceTypes();
		
		System.out.println("Service type size is ******** "+servicesTypes.size());
		model.addAttribute("orgUnit", new OrganisationUnit());
		model.addAttribute("orgUnitLevels", orgUnitLevels);
		model.addAttribute("servicesTypes", servicesTypes);
		
		return "newOrgUnit";
	}
	
	@RequestMapping(value="/submitOrgUnit", method=RequestMethod.POST)
	public String addOrganisationUnit(@ModelAttribute OrganisationUnit orgUnit){
		
		System.out.println(orgUnit);
		return "redirect:/addOrgUnit";
	}
}
