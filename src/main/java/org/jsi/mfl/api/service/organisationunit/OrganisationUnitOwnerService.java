package org.jsi.mfl.api.service.organisationunit;

import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitOwner;

public interface OrganisationUnitOwnerService {

	public List<OrganisationUnitOwner> getOwners();
	public void updateOwner(OrganisationUnitOwner owner);
	public OrganisationUnitOwner getOwnerById(int id);
	public OrganisationUnitOwner getOwnerByUuid(String uuid);
	public void addOwner(OrganisationUnitOwner owner);
}
