package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;

public interface OrganisationUnitDAO {
	
	public void addOrganistionUnit(OrganisationUnit organisationUnit);
	public List<OrganisationUnit> getOrganisationUnits();
	public List<OrganisationUnit> getOrganisationUnitsByLevel(int level);
	public List<OrganisationUnit> getOrganisationUnitChild(int parentId);
	public void updateOrganisationUnit(OrganisationUnit organisationUnit);
	public OrganisationUnit getOrganisationUnitByUuid(String uuid);
	public void addOrganistionUnitInitial(OrganisationUnit organisationUnit);
	public List<OrganisationUnit> getOrganisationUnitChild();
	public List<OrganisationUnit> searchForOrganisationUnits(String searchTerm);
}
