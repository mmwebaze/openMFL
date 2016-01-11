package org.jsi.mfl.web.api.webservices.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitLevelService;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitService;
import org.jsi.mfl.api.service.servicetype.ServiceTypeService;
import org.jsi.mfl.dummies.DummyData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganisationUnitWebServices {
	@Resource
	private OrganisationUnitService organisationUnitService;
	@Resource
	private OrganisationUnitLevelService organisationUnitLevelService;
	@Resource
	private ServiceTypeService serviceTypeService;
	
	@RequestMapping("/dummyorgunits/{task}")
	public String dataSetUp(@PathVariable String task){
		
		if (task.equalsIgnoreCase("clear"))
		return "Data base cleared";
		else{
			List<OrganisationUnit> orgUnitsToAdd = DummyData.getOrgUnits();
			
			for (OrganisationUnit orgUnit : orgUnitsToAdd)
				organisationUnitService.addOrganistionUnit(orgUnit);
			
			List<ServiceType> serviceTypes = DummyData.generateServiceTypes();
			
			for (ServiceType serviceType : serviceTypes)
				serviceTypeService.addServiceType(serviceType);
			return "Dummy data added";
		}
	}

	@RequestMapping("/api/organisationUnits")
	public List<OrganisationUnit> getOrganisationUnits(){
		
		return organisationUnitService.getOrganisationUnits();
	}
	
	@RequestMapping("/api/organisationUnits/{level}")
	public List<OrganisationUnit> getOrganisationUnitsByLevel(@PathVariable int level){
		
		return organisationUnitService.getOrganisationUnitsByLevel(level);
	}
	@RequestMapping("/api/organisationUnitLevels")
	public List<OrganisationUnitLevel> getOrganisationUnitsLevels(){
		
		return organisationUnitLevelService.getOrganisationUnitLevels();
	}
}
