package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;

public interface OrganisationUnitDAO {
	
	public void addOrganistionUnit(OrganisationUnit organisationUnit);
	public List<OrganisationUnit> getOrganisationUnits();

}
