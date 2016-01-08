package org.jsi.mfl.dummies;

import java.util.ArrayList;
import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;

public class DummyOrganisationUnits {
	
	public static List<OrganisationUnit> getOrgUnits(){
		List<OrganisationUnit> orgUnitList = new ArrayList<>();
		OrganisationUnit a = new OrganisationUnit();
		a.setOrganistaionUnitName("Namibia");
		a.setOrganisationUnitCode("NA");
		a.setOrganistionUnitLevel(1);
		orgUnitList.add(a);
		
		OrganisationUnit b = new OrganisationUnit();
		b.setOrganistaionUnitName("Karas Region");
		b.setOrganisationUnitCode("KR");
		b.setOrganistionUnitLevel(2);
		orgUnitList.add(b);
		
		return orgUnitList;
	}

}
