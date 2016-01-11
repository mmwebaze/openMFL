package org.jsi.mfl.api.service.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.organisationunit.OrganisationUnitDAO;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.springframework.stereotype.Component;

@Component
public class OrganisationUnitService {
	
	@Resource
	private OrganisationUnitDAO organisationUnitDao;
	
	public void addOrganistionUnit(OrganisationUnit organisationUnit){
		organisationUnitDao.addOrganistionUnit(organisationUnit);
	}
	
	public List<OrganisationUnit> getOrganisationUnits(){
		return organisationUnitDao.getOrganisationUnits();
	}
	public List<OrganisationUnit> getOrganisationUnitsByLevel(int level) {
		return organisationUnitDao.getOrganisationUnitsByLevel(level);
	}
}
