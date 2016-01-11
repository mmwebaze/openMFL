package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import javax.transaction.Transactional;

import org.jsi.mfl.api.dao.DataAccessConfig;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganisationUnitDaoImpl extends DataAccessConfig implements OrganisationUnitDAO{
	

	@Override
	public void addOrganistionUnit(OrganisationUnit organisationUnit) {
		
		entityManager.persist(organisationUnit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganisationUnit> getOrganisationUnits() {
		return entityManager.createQuery("from OrganisationUnit" ).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganisationUnit> getOrganisationUnitsByLevel(int level) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from OrganisationUnit where organistionUnitLevel = :level" ).setParameter("level", level).getResultList();
	}

}
