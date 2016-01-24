package org.jsi.mfl.api.service.organisationunit;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.organisationunit.OrganisationUnitTypeDAO;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.springframework.stereotype.Component;

@Component
public class OrganisationUnitTypeServiceImpl implements OrganisationUnitTypeService{

	@Resource
	private OrganisationUnitTypeDAO orgUnitTypeDao;
	
	@Override
	public void addOrganisationUnitType(
			OrganisationUnitType organisationUnitType) {
		orgUnitTypeDao.addOrganisationUnitType(organisationUnitType);		
	}

	@Override
	public List<OrganisationUnitType> getOrganisationUnitTypes() {
		return orgUnitTypeDao.getOrganisationUnitTypes();
	}

}
