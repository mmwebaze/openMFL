package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganisationUnitDaoImpl implements OrganisationUnitDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	public void addOrganistionUnit(OrganisationUnit organisationUnit) {
		
		entityManager.persist(organisationUnit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganisationUnit> getOrganisationUnits() {
		return entityManager.createQuery("from OrganisationUnit" ).getResultList();
	}

}
