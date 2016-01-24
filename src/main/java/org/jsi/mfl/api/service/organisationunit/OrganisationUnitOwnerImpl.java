package org.jsi.mfl.api.service.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.organisationunit.OrganisationUnitOwnerDAO;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitOwner;
import org.springframework.stereotype.Component;

@Component
public class OrganisationUnitOwnerImpl implements OrganisationUnitOwnerService{

	@Resource
	private OrganisationUnitOwnerDAO orgUnitOwnerDao;
	@Override
	public List<OrganisationUnitOwner> getOwners() {
		return orgUnitOwnerDao.getOwners();
	}

	@Override
	public void updateOwner(OrganisationUnitOwner owner) {
		orgUnitOwnerDao.updateOwner(owner);
		
	}

	@Override
	public OrganisationUnitOwner getOwnerById(int id) {
		return orgUnitOwnerDao.getOwnerById(id);
	}

	@Override
	public OrganisationUnitOwner getOwnerByUuid(String uuid) {
		return orgUnitOwnerDao.getOwnerByUuid(uuid);
	}

	@Override
	public void addOwner(OrganisationUnitOwner owner) {
		orgUnitOwnerDao.addOwner(owner);
	}

}
