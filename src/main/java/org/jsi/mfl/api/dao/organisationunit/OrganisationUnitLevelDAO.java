package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.LevelMapping;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;

public interface OrganisationUnitLevelDAO {

	public void addOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel);
	public List<LevelMapping> getOrganisationUnitLevel(int levelId);
	public void updateOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel);
	public List<OrganisationUnitLevel> getOrganisationalUnitLevels();
}
