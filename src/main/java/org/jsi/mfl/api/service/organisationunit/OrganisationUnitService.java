package org.jsi.mfl.api.service.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.organisationunit.OrganisationUnitDAO;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.springframework.stereotype.Component;

@Component
public class OrganisationUnitService {

	@Resource
	private OrganisationUnitDAO organisationUnitDao;

	public void addOrganistionUnit(OrganisationUnit organisationUnit){
		OrganisationUnitLevel orgUnitLevel = organisationUnit.getOrganisationUnitLevel();
		orgUnitLevel.setId(orgUnitLevel.getId() + 2);
		System.out.println("**** "+organisationUnit.toString());
		organisationUnit.setOrganisationUnitLevel(orgUnitLevel);
		organisationUnitDao.addOrganistionUnit(organisationUnit);
	}

	public List<OrganisationUnit> getOrganisationUnits(){
		return organisationUnitDao.getOrganisationUnits();
	}
	public List<OrganisationUnit> getOrganisationUnitsByLevel(int level) {
		return organisationUnitDao.getOrganisationUnitsByLevel(level);
	}
	public List<OrganisationUnit> getOrganisationUnitChild(int parentId){
		return organisationUnitDao.getOrganisationUnitChild(parentId);
	}
	public void updateOrganisationUnit(OrganisationUnit organisationUnit){
		organisationUnitDao.updateOrganisationUnit(organisationUnit);
	}
	public OrganisationUnit getOrganisationUnitByUuid(String uuid){

		return organisationUnitDao.getOrganisationUnitByUuid(uuid);
	}
	public void addOrganistionUnitInitial(OrganisationUnit organisationUnit){

		organisationUnitDao.addOrganistionUnitInitial(organisationUnit);
	}
	public List<OrganisationUnit> getOrganisationUnitChild(){
		return organisationUnitDao.getOrganisationUnitChild();	
	}
	public List<OrganisationUnit> searchForOrganisationUnits(String searchTerm){
		String search = searchTerm+"%";
		//System.out.println("Search term is: "+search);
		return organisationUnitDao.searchForOrganisationUnits(search);
	}
}
