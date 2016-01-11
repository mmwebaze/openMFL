package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import javax.transaction.Transactional;

import org.jsi.mfl.api.dao.DataAccessConfig;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganisationUnitLevelDaoImpl extends DataAccessConfig implements OrganisationUnitLevelDAO{
	
	@Override
	public void addOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel) {
		entityManager.persist(organisationUnitLevel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganisationUnitLevel> getOrganisationUnitLevels() {
		return entityManager.createQuery("from OrganisationUnitLevel" ).getResultList();
	}

	@Override
	public void updateOrganisationUnitLevel(
			OrganisationUnitLevel organisationUnitLevel) {
		// TODO Auto-generated method stub
		
	}

}
