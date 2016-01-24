package org.jsi.mfl.api.service.organisationunit;

import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;

public interface OrganisationUnitTypeService {
	public void addOrganisationUnitType(OrganisationUnitType organisationUnitType);
	public List<OrganisationUnitType> getOrganisationUnitTypes();
}
