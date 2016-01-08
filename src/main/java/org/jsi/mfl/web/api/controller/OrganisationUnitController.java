package org.jsi.mfl.web.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitService;
import org.jsi.mfl.dummies.DummyOrganisationUnits;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganisationUnitController {
	@Resource
	private OrganisationUnitService organisationUnitService;
	@RequestMapping("/dummyorgunits/{task}")
	public String dataSetUp(@PathVariable String task){
		
		System.out.println("task is "+task);
		
		if (task.equalsIgnoreCase("clear"))
		return "Data base cleared";
		else{
			List<OrganisationUnit> orgUnitsToAdd = DummyOrganisationUnits.getOrgUnits();
			
			for (OrganisationUnit orgUnit : orgUnitsToAdd)
				organisationUnitService.addOrganistionUnit(orgUnit);
			return "Dummy data added";
		}
	}

	@RequestMapping("/api/organisationUnits")
	public List<OrganisationUnit> getOrganisationUnits(){
		
		return organisationUnitService.getOrganisationUnits();
	}
}
