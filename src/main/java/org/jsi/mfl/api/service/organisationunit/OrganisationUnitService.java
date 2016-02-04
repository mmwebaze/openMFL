package org.jsi.mfl.api.service.organisationunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.organisationunit.OrganisationUnitDAO;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.util.QueryUtil;
import org.springframework.stereotype.Component;

@Component
public class OrganisationUnitService {

	@Resource
	private OrganisationUnitDAO organisationUnitDao;

	public void addOrganistionUnit(OrganisationUnit organisationUnit){
		OrganisationUnitLevel orgUnitLevel = organisationUnit.getOrganisationUnitLevel();
		orgUnitLevel.setId(orgUnitLevel.getId() + 2);
		System.out.println("**** "+organisationUnit.toString());
		organisationUnit.setOrganisationUnitLevel(orgUnitLevel);
		organisationUnitDao.addOrganistionUnit(organisationUnit);
	}

	public List<OrganisationUnit> getOrganisationUnits(){
		return organisationUnitDao.getOrganisationUnits();
	}
	public List<OrganisationUnit> getOrganisationUnitsByLevel(int level) {
		return organisationUnitDao.getOrganisationUnitsByLevel(level);
	}
	public List<OrganisationUnit> getOrganisationUnitChild(int parentId){
		return organisationUnitDao.getOrganisationUnitChild(parentId);
	}
	public void updateOrganisationUnit(OrganisationUnit organisationUnit){
		organisationUnitDao.updateOrganisationUnit(organisationUnit);
	}
	public OrganisationUnit getOrganisationUnitByUuid(String uuid){

		return organisationUnitDao.getOrganisationUnitByUuid(uuid);
	}
	public void addOrganistionUnitInitial(OrganisationUnit organisationUnit){

		organisationUnitDao.addOrganistionUnitInitial(organisationUnit);
	}
	public List<OrganisationUnit> getOrganisationUnitChild(){
		return organisationUnitDao.getOrganisationUnitChild();	
	}
	public List<OrganisationUnit> searchForOrganisationUnits(String searchTerm, boolean exclude, int orgUnitTypeId){
		String search = searchTerm+"%";
		return organisationUnitDao.searchForOrganisationUnits(search, QueryUtil.searchQuery(exclude, orgUnitTypeId), orgUnitTypeId);
	}
	public List<String> getOrganisationUnitGeojsonById(String ids){
		List<String> geoJsons = new ArrayList<String>();
		List<String> items = Arrays.asList(ids.split("\\s*,\\s*"));
		for (String s : items){
			int id = Integer.parseInt(s);
			System.out.println(id);
			String geoJson = organisationUnitDao.getOrganisationUnitGeojsonById(id);
			if (geoJson != null){
				geoJsons.add(organisationUnitDao.getOrganisationUnitGeojsonById(id));
				//geoJsons.add(",");
			}
		}
		/*int numberGeoJsons = geoJsons.size();
		if (numberGeoJsons > 0)
			geoJsons.remove(numberGeoJsons - 1);*/

		return geoJsons;
	}
}
