package org.jsi.mfl.api.dao.organisationunit;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jsi.mfl.api.dao.DataAccessConfig;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitOwner;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitWrapper;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganisationUnitDaoImpl extends DataAccessConfig implements OrganisationUnitDAO{


	@Override
	public void addOrganistionUnit(OrganisationUnit organisationUnit) {
		organisationUnit.setOrganisationUnitLevel(entityManager.find(OrganisationUnitLevel.class, organisationUnit.getOrganisationUnitLevel().getId()));
		organisationUnit.setOrgUnitType(entityManager.find(OrganisationUnitType.class, organisationUnit.getOrgUnitType().getId()));
		organisationUnit.setOrgUnitOwner(entityManager.find(OrganisationUnitOwner.class, organisationUnit.getOrgUnitOwner().getId()));
		Collection<ServiceType> selectedServiceTypes = organisationUnit.getOrgUnitServices();

		for (ServiceType serviceType : selectedServiceTypes){
			serviceType.setName(entityManager.find(ServiceType.class, serviceType.getId()).getName());

		}
		//entityManager.merge(organisationUnit);
		OrganisationUnit orgUnit = entityManager.find(OrganisationUnit.class, organisationUnit.getIdParent());
		organisationUnit.setParent(orgUnit);

		entityManager.merge(organisationUnit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganisationUnit> getOrganisationUnits() {
		return entityManager.createQuery("from OrganisationUnit" ).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganisationUnit> getOrganisationUnitsByLevel(int level) {
		return entityManager.createQuery("from OrganisationUnit where organistionUnitLevel = :level" ).setParameter("level", level).getResultList();
	}

	public List<OrganisationUnit> getOrganisationUnitChild(int parentId){

		//return entityManager.createQuery("Select OU from OrganisationUnit OU where OU.parent.id = :parentId" ).setParameter("parentId", parentId).getResultList();
		TypedQuery<OrganisationUnit> x = entityManager.createQuery("select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnit(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus, p.ownerName) from OrganisationUnit o LEFT OUTER JOIN o.orgUnitOwner p where parentId = :parentId", OrganisationUnit.class ).setParameter("parentId", parentId);
		List<OrganisationUnit> orgUnits = x.getResultList();

		return orgUnits;
	}
	//Returns only immediate children of root parent since it doesn't have a parent of its own. Hence the NULL
	public List<OrganisationUnit> getOrganisationUnitChild(){

		//return entityManager.createQuery("Select OU from OrganisationUnit OU where OU.parent.id = :parentId" ).setParameter("parentId", parentId).getResultList();
		TypedQuery<OrganisationUnit> x = entityManager.createQuery("select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnit(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus, p.ownerName) from OrganisationUnit o LEFT OUTER JOIN o.orgUnitOwner p where parentId IS NULL", OrganisationUnit.class );
		OrganisationUnit orgUnit = x.getSingleResult();
		List<OrganisationUnit> orgUnits = this.getOrganisationUnitChild(orgUnit.getId());
		return orgUnits;
	}
	@Override
	public void updateOrganisationUnit(OrganisationUnit organisationUnit) {
		OrganisationUnit parent = entityManager.find(OrganisationUnit.class, organisationUnit.getIdParent());
		organisationUnit.setParent(parent);
		//organisationUnit.setOrganisationUnitLevel(entityManager.find(OrganisationUnitLevel.class, organisationUnit.getOrganisationUnitLevel().getId()));
		//organisationUnit.setOrgUnitType(entityManager.find(OrganisationUnitType.class, organisationUnit.getOrgUnitType().getId()));
		//organisationUnit.setOrgUnitOwner(entityManager.find(OrganisationUnitOwner.class, organisationUnit.getOrgUnitOwner().getId()));
		entityManager.find(OrganisationUnit.class, organisationUnit.getId());

		entityManager.merge(organisationUnit);
	}

	@Override
	public OrganisationUnit getOrganisationUnitByUuid(String uuid) {
		OrganisationUnit orgUnit = new OrganisationUnit();
		//List<OrganisationUnit> o = entityManager.createQuery("Select o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus, p from OrganisationUnit o LEFT JOIN  o.orgUnitServices p where uuid = :uuid", OrganisationUnit.class ).setParameter("uuid", uuid).getResultList();
		TypedQuery<OrganisationUnitWrapper> typedQuery = entityManager.createQuery("select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnitWrapper(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus, w.ownerName, t.typeName, s.name, p.id as parentId) from OrganisationUnit o LEFT JOIN o.orgUnitOwner w LEFT JOIN o.orgUnitType t LEFT JOIN o.orgUnitServices s LEFT JOIN o.parent p where o.uuid = :uuid", OrganisationUnitWrapper.class);
		typedQuery.setParameter("uuid", uuid);
		List<OrganisationUnitWrapper> orgUnitWrappers = typedQuery.getResultList();
		OrganisationUnitWrapper orgUnitWrapper = orgUnitWrappers.get(0);
		orgUnit.setId(orgUnitWrapper.getId());
		orgUnit.setUuid(orgUnitWrapper.getUuid());
		orgUnit.setOrganisationUnitName(orgUnitWrapper.getOrganisationUnitName());
		orgUnit.setOrganisationUnitCode(orgUnitWrapper.getOrganisationUnitCode());
		orgUnit.setOperationalStatus(orgUnitWrapper.getOperationalStatus());
		OrganisationUnitOwner owner = new OrganisationUnitOwner();
		owner.setOwnerName(orgUnitWrapper.getOwnerName());
		orgUnit.setOrgUnitOwner(owner);
		OrganisationUnitType orgUnitType = new OrganisationUnitType();
		orgUnitType.setTypeName(orgUnitWrapper.getTypeName());
		orgUnit.setOrgUnitType(orgUnitType);
		orgUnit.setIdParent(orgUnitWrapper.getParentId());

		for (OrganisationUnitWrapper wr : orgUnitWrappers){
			if (wr.getName() != null)
				orgUnit.getOrgUnitServices().add(new ServiceType(wr.getName()));
		}
		return orgUnit;
	}

	@Override
	public void addOrganistionUnitInitial(OrganisationUnit organisationUnit) {
		OrganisationUnitLevel level = entityManager.find(OrganisationUnitLevel.class, organisationUnit.getOrganisationUnitLevel().getId());
		organisationUnit.setOrganisationUnitLevel(level);
		entityManager.persist(organisationUnit);
	}

	@Override
	public List<OrganisationUnit> searchForOrganisationUnits(String search) {

		TypedQuery<OrganisationUnit> typedQuery = entityManager.createQuery("SELECT NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnit(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode,o.operationalStatus, p.ownerName) from OrganisationUnit o LEFT JOIN o.orgUnitOwner p where organisationunitcode  LIKE :searchTerm OR organisationunitname LIKE :searchTerm", OrganisationUnit.class);
		List<OrganisationUnit> orgUnits = typedQuery.setParameter("searchTerm", search).getResultList();
		//this.assignOrganisationUnitUuid();

		return orgUnits;
	}
	/*public void assignOrganisationUnitUuid(){
		TypedQuery<OrganisationUnit> typedQuery = entityManager.createQuery("SELECT NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnit(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode,o.operationalStatus, p.ownerName) from OrganisationUnit o LEFT JOIN o.orgUnitOwner p", OrganisationUnit.class);
		List<OrganisationUnit> orgUnits = typedQuery.getResultList();
		
		for (OrganisationUnit o : orgUnits){
			OrganisationUnit k = entityManager.find(OrganisationUnit.class, o.getId());
			k.setUuid(UUID.randomUUID().toString());
			entityManager.merge(k);
		}
	}*/
}
