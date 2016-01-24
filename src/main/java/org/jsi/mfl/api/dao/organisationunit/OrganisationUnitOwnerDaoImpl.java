package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jsi.mfl.api.dao.DataAccessConfig;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitOwner;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganisationUnitOwnerDaoImpl extends DataAccessConfig implements OrganisationUnitOwnerDAO{

	@Override
	public List<OrganisationUnitOwner> getOwners() {
		TypedQuery<OrganisationUnitOwner> owners = entityManager.createQuery("from OrganisationUnitOwner", OrganisationUnitOwner.class);
		return owners.getResultList();
	}

	@Override
	public void updateOwner(OrganisationUnitOwner owner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrganisationUnitOwner getOwnerById(int id) {
		OrganisationUnitOwner owner = entityManager.find(OrganisationUnitOwner.class, id);
		return owner;
	}

	@Override
	public OrganisationUnitOwner getOwnerByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOwner(OrganisationUnitOwner owner) {
		entityManager.persist(owner);
	}

}
