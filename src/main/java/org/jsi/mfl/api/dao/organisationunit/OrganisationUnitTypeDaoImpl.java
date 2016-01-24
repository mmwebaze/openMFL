package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import javax.transaction.Transactional;

import org.jsi.mfl.api.dao.DataAccessConfig;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganisationUnitTypeDaoImpl extends DataAccessConfig implements OrganisationUnitTypeDAO{

	@Override
	public void addOrganisationUnitType(OrganisationUnitType organisationUnitType) {
		entityManager.persist(organisationUnitType);
	}

	@Override
	public List<OrganisationUnitType> getOrganisationUnitTypes() {
		return entityManager.createQuery("from OrganisationUnitType" ).getResultList();
	}
}
