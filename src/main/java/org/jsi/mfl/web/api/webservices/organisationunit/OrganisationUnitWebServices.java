package org.jsi.mfl.web.api.webservices.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.domain.organisationunit.LevelMapping;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitOwner;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitLevelService;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitOwnerService;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitService;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitTypeServiceImpl;
import org.jsi.mfl.api.service.servicetype.ServiceTypeService;
import org.jsi.mfl.dummies.DummyData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganisationUnitWebServices {
	@Resource
	private OrganisationUnitService organisationUnitService;
	@Resource
	private OrganisationUnitLevelService organisationUnitLevelService;
	@Resource
	private ServiceTypeService serviceTypeService;
	@Resource
	private OrganisationUnitTypeServiceImpl orgUnitTypeService;
	@Resource
	private OrganisationUnitOwnerService orgUnitOwnerService;

	@RequestMapping("/dummyorgunits/{task}")
	public String dataSetUp(@PathVariable String task){

		if (task.equalsIgnoreCase("clear"))
			return "Data base cleared";
		else{
			List<ServiceType> serviceTypes = DummyData.generateServiceTypes();
			for (ServiceType serviceType : serviceTypes)
				serviceTypeService.addServiceType(serviceType);
			List<OrganisationUnitLevel> levels = DummyData.generateOrgUnitLevels();
			for (OrganisationUnitLevel level : levels)
				organisationUnitLevelService.addOrganisationUnitLevel(level);
			for (OrganisationUnit orgUnit : DummyData.getOrgUnits())
			organisationUnitService.addOrganistionUnitInitial(orgUnit);
			
			for (OrganisationUnitType orgUnitType : DummyData.generateOrgUnitTypes())
				orgUnitTypeService.addOrganisationUnitType(orgUnitType);
			
			for (OrganisationUnitOwner owner : DummyData.getOrgUnitOwners())
				orgUnitOwnerService.addOwner(owner);
			
			return "Dummy data added";
		}
	}

	@RequestMapping("/api/addOrganisationUnit")
	public String addOrganisationUnit(int idParent, /*int orgUnitLevelId,*/ int orgUnitType, String organisationUnitCode, String organisationUnitName, boolean operationalStatus, int[] orgUnitServices){
		OrganisationUnit orgUnit = new OrganisationUnit();
		orgUnit.setIdParent(idParent);
		orgUnit.setOrgUnitTypeId(orgUnitType);
		orgUnit.setOrganisationUnitCode(organisationUnitCode);
		orgUnit.setOrganisationUnitName(organisationUnitName);
		orgUnit.setOperationalStatus(new Boolean(operationalStatus));
		
		if (orgUnitServices != null)
		for (int x = 0; x < orgUnitServices.length; x++){
			ServiceType serviceTyp = new ServiceType();
			serviceTyp.setId(orgUnitServices[x]);
			orgUnit.getOrgUnitServices().add(serviceTyp);
		}
		organisationUnitService.addOrganistionUnit(orgUnit);
		return "ADDED";
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
	@RequestMapping("/api/organisationUnitChildren/{parentId}")
	public List<OrganisationUnit> getOrganisationUnitsChildren(@PathVariable int parentId){

		return organisationUnitService.getOrganisationUnitChild(parentId);
	}
	@RequestMapping("/api/organisationUnit/{uuid}")
	public String getOrganisationUnitJsonByUuid(@PathVariable String uuid){

		return organisationUnitService.getOrganisationUnitByUuid(uuid).getGeoJson();
	}
	@RequestMapping(value="/api/search", method=RequestMethod.POST)
	public List<OrganisationUnit> searchOrganisationUnit(String searchTerm, boolean exclude, Integer orgUnitTypeId){
		
		List<OrganisationUnit> soughtOrgUnits = organisationUnitService.searchForOrganisationUnits(searchTerm, exclude, orgUnitTypeId);
		
		return soughtOrgUnits;
	}
	@RequestMapping(value="/api/organisationUnitLevel/{level}", method=RequestMethod.GET)
	public List<LevelMapping> getOrganisationUnitLevel(@PathVariable int level){
		
		return organisationUnitLevelService.getOrganisationUnitLevel(level);
		
	}
	
}
