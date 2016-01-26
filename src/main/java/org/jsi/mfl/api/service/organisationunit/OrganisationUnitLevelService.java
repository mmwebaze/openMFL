package org.jsi.mfl.api.service.organisationunit;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.organisationunit.OrganisationUnitLevelDAO;
import org.jsi.mfl.api.domain.organisationunit.LevelMapping;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.springframework.stereotype.Component;

@Component
public class OrganisationUnitLevelService implements OranisationUnitLevel{

	@Resource
	private OrganisationUnitLevelDAO organisationUnitLevelDAO;
	
	public void addOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel){
		organisationUnitLevel.setUuid(UUID.randomUUID().toString());
		organisationUnitLevelDAO.addOrganisationUnitLevel(organisationUnitLevel);
	}
	public List<LevelMapping> getOrganisationUnitLevel(int levelId){
		
		return organisationUnitLevelDAO.getOrganisationUnitLevel(levelId);
	}
	public void updateOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel){
		organisationUnitLevelDAO.updateOrganisationUnitLevel(organisationUnitLevel);
	}
	@Override
	public List<OrganisationUnitLevel> getOrganisationUnitLevels() {
		
		return organisationUnitLevelDAO.getOrganisationalUnitLevels();
	}
}
