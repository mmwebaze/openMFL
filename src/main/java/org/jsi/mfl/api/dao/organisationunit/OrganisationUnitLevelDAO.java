package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;

public interface OrganisationUnitLevelDAO {

	public void addOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel);
	public List<OrganisationUnitLevel> getOrganisationUnitLevels();
	public void updateOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel);
}
