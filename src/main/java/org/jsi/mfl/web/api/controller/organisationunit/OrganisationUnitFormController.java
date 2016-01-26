package org.jsi.mfl.web.api.controller.organisationunit;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitOwner;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitLevelService;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitOwnerService;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitService;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitTypeService;
import org.jsi.mfl.api.service.servicetype.ServiceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrganisationUnitFormController {

	@Resource
	private OrganisationUnitLevelService organisationUnitLevelService;
	@Resource
	private ServiceTypeService serviceTypeService;
	@Resource
	private OrganisationUnitService organisationUnitService;
	@Resource
	private OrganisationUnitTypeService organisationUnitTypeService;
	@Resource
	private OrganisationUnitOwnerService orgUnitOwnerService;
	
	@RequestMapping(value="/addOrgUnit", method=RequestMethod.GET)
	public String addOrganisationUnitForm(Model model){
		model.addAttribute("orgUnit", new OrganisationUnit());
		List<OrganisationUnitLevel> orgUnitLevels = organisationUnitLevelService.getOrganisationUnitLevels();
		model.addAttribute("orgUnitLevels", orgUnitLevels);
		List<OrganisationUnit> orgUnits = organisationUnitService.getOrganisationUnits();
		model.addAttribute("orgUnits", orgUnits);
		List<ServiceType> servicesTypes = serviceTypeService.getServiceTypes();
		model.addAttribute("servicesTypes", servicesTypes);
		List<OrganisationUnitType> orgUnitTypes = organisationUnitTypeService.getOrganisationUnitTypes();
		model.addAttribute("orgUnitTypes", orgUnitTypes);
		List<OrganisationUnitOwner> owners = orgUnitOwnerService.getOwners();
		model.addAttribute("owners", owners);
		List<OrganisationUnit> leveTwoOrgUnits = organisationUnitService.getOrganisationUnitChild();
		model.addAttribute("levelTwoOrgUnits", leveTwoOrgUnits);
		
		return "addOrgUnit";
	}
	
	@RequestMapping(value="/submitOrgUnit", method=RequestMethod.POST)
	public String addOrganisationUnit(@ModelAttribute(value="orgUnit") @Valid OrganisationUnit orgUnit, BindingResult bindingResult){
		System.out.println("++ > "+orgUnit);
		
		organisationUnitService.addOrganistionUnit(orgUnit);
		return "redirect:/addOrgUnit";
	}
	@RequestMapping(value="/manageOrgUnits", method=RequestMethod.GET)
	public String organisationUnitManager(Model model){
		model.addAttribute("orgUnit", new OrganisationUnit());
		List<OrganisationUnitLevel> orgUnitLevels = organisationUnitLevelService.getOrganisationUnitLevels();
		model.addAttribute("orgUnitLevels", orgUnitLevels);
		List<OrganisationUnit> orgUnits = organisationUnitService.getOrganisationUnits();
		model.addAttribute("orgUnits", orgUnits);
		List<OrganisationUnit> leveTwoOrgUnits = organisationUnitService.getOrganisationUnitChild();
		model.addAttribute("levelTwoOrgUnits", leveTwoOrgUnits);
		
		/*List<OrganisationUnitType> orgUnitTypes = organisationUnitTypeService.getOrganisationUnitTypes();
		model.addAttribute("orgUnitTypes", orgUnitTypes);*/
		return "manageOrgUnits";
	}
	
	@RequestMapping(value="/editorgunit", method=RequestMethod.GET)
	public String editOrganisationUnitForm(@RequestParam("uuid") String uuid, Model model){
		OrganisationUnit orgUnit = organisationUnitService.getOrganisationUnitByUuid(uuid);
		System.out.println(orgUnit.getIdParent());
		//orgUnit.setIdParent(orgUnit.getParent().getId());
		model.addAttribute("orgUnit", orgUnit);
		
		return "editOrgUnit";
	}
	@RequestMapping(value="/updateOrgUnit", method=RequestMethod.POST)
	public String updateOrganisationUnit(@ModelAttribute(value="orgUnit") @Valid OrganisationUnit orgUnit, BindingResult bindingResult){
		System.out.println(orgUnit.toString());
		
		organisationUnitService.updateOrganisationUnit(orgUnit);
		return "redirect:/manageOrgUnits";
	}
	
/*	@RequestMapping(value="/addOrgUnitType", method=RequestMethod.GET)
	public String addOrganisationUnitTypeForm(Model model){
		model.addAttribute("orgUnitType", new OrganisationUnitType());
		return "addOrgUnitType";
	}
	@RequestMapping(value="/submitOrgUnitType", method=RequestMethod.POST)
	public String addOrganisationUnitType(@ModelAttribute(value="orgUnitType") @Valid OrganisationUnitType orgUnitType){
		System.out.println(orgUnitType);
		
		organisationUnitTypeService.addOrganisationUnitType(orgUnitType);
		return "redirect:/addOrgUnitType";
	}*/
	@RequestMapping(value="/vieworgunit", method=RequestMethod.GET)
	public String organisationUnitDetail(@RequestParam("uuid") String uuid, Model model){
		
		OrganisationUnit orgUnit = organisationUnitService.getOrganisationUnitByUuid(uuid);
		System.out.println("> "+orgUnit);
		OrganisationUnitType orgUnitType = orgUnit.getOrgUnitType();
		
		if (orgUnitType == null){
			orgUnitType = new OrganisationUnitType();
			orgUnitType.setTypeName("-");
			orgUnit.setOrgUnitType(orgUnitType);
		}
			
		model.addAttribute("orgUnit", orgUnit);
		return "orgUnitDetails";
	}
}
