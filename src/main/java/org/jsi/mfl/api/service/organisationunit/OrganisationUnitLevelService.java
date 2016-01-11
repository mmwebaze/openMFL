package org.jsi.mfl.api.service.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.organisationunit.OrganisationUnitLevelDAO;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.springframework.stereotype.Component;

@Component
public class OrganisationUnitLevelService {

	@Resource
	private OrganisationUnitLevelDAO organisationUnitLevelDAO;
	
	public void addOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel){
		organisationUnitLevelDAO.addOrganisationUnitLevel(organisationUnitLevel);
	}
	public List<OrganisationUnitLevel> getOrganisationUnitLevels(){
		
		return organisationUnitLevelDAO.getOrganisationUnitLevels();
	}
	public void updateOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel){
		organisationUnitLevelDAO.updateOrganisationUnitLevel(organisationUnitLevel);
	}
}
