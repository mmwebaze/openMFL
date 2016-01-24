package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;

public interface OrganisationUnitTypeDAO {
	public void addOrganisationUnitType(OrganisationUnitType organisationUnitType);
	public List<OrganisationUnitType> getOrganisationUnitTypes();
}
