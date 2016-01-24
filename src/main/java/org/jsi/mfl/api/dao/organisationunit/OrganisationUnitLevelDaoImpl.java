package org.jsi.mfl.api.dao.organisationunit;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jsi.mfl.api.dao.DataAccessConfig;
import org.jsi.mfl.api.domain.organisationunit.LevelMapping;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganisationUnitLevelDaoImpl extends DataAccessConfig implements OrganisationUnitLevelDAO{

	@Override
	public void addOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel) {
		entityManager.persist(organisationUnitLevel);
	}

	@Override
	public List<LevelMapping> getOrganisationUnitLevel(int levelId) {
		List<LevelMapping> results = entityManager.createNativeQuery("select o.id, o.organisationunitname, orl.name from OrganisationUnit o inner join orgunit_level ol on (o.id = ol.orgunit_id) inner join orgunitlevel orl on (orl.id = ol.level_id) where orl.id = :id", "orgunitByLevel").setParameter("id",levelId).getResultList();
		/*for (LevelMapping m : results)
			System.out.println(m);*/
		//TypedQuery<OrganisationUnitLevel> query = entityManager.createQuery("select o from OrganisationUnitLevel o JOIN FETCH o.organisationUnit where o.id = :id", OrganisationUnitLevel.class );
		//TypedQuery<OrganisationUnitLevel> query = entityManager.createQuery("select o from OrganisationUnitLevel o JOIN FETCH o.organisationUnit where o.id = :id", OrganisationUnitLevel.class );
		
		return results;
	}

	@Override
	public void updateOrganisationUnitLevel(
			OrganisationUnitLevel organisationUnitLevel) {

	}

	@Override
	public List<OrganisationUnitLevel> getOrganisationalUnitLevels() {
		TypedQuery<OrganisationUnitLevel> query = entityManager.createQuery("select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel(o.id, o.uuid, o.name) from OrganisationUnitLevel o", OrganisationUnitLevel.class );
		//List<OrganisationUnitLevel> results = entityManager.createNativeQuery("select o.name, o.uuid, o.id, o.code, o.level from organisationunit_level o inner join o.organisationUnit orgs where o.id = :id", OrganisationUnitLevel.class).setParameter("id", 1).getResultList();
		/*select o.organisationunitname, orl.name from organisationunit  o inner join orgunit_level ol on (o.id = ol.orgunit_id)
		inner join organisationunit_level orl on (orl.id = ol.level_id) where orl.id = 4*/
		
		return query.getResultList();
	}

}
