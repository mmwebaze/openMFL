package org.jsi.mfl.dummies;

import java.util.ArrayList;
import java.util.List;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.domain.user.User;

import scala.annotation.serializable;

public class DummyData {
	
	public static List<OrganisationUnit> getOrgUnits(){
		User user1 = new User();
		user1.setFirstName("michael");
		user1.setLastName("Mwebaze");
		user1.setEmail("email");
		user1.setPassword("password");
		user1.setUsername("username");
		
		User user2 = new User();
		user2.setFirstName("Sarah");
		user2.setLastName("Syambi");
		user2.setEmail("email");
		user2.setPassword("password");
		user2.setUsername("username");
		
		User user3 = new User();
		user3.setFirstName("Tabitha");
		user3.setLastName("Shemeera");
		user3.setEmail("email");
		user3.setPassword("password");
		user3.setUsername("username");
		
		List<OrganisationUnit> orgUnitList = new ArrayList<>();
		OrganisationUnit a = new OrganisationUnit();
		a.setOrganistaionUnitName("Namibia");
		a.setOrganisationUnitCode("NA");
		OrganisationUnitLevel national = new OrganisationUnitLevel();
		national.setLevel(1);
		national.setName("National");
		a.setOrganisationUnitLevel(national);
		a.getUsers().add(user1);
		//a.setParentId(0);
		orgUnitList.add(a);
		
		OrganisationUnit b = new OrganisationUnit();
		b.setOrganistaionUnitName("Karas Region");
		b.setOrganisationUnitCode("KR");
		OrganisationUnitLevel regional = new OrganisationUnitLevel();
		regional.setLevel(2);
		regional.setName("Regional");
		b.setOrganisationUnitLevel(regional);
		b.setParentId(1);
		b.getUsers().add(user2);
		b.getUsers().add(user3);
		//b.setParent(a);
		orgUnitList.add(b);
		
		OrganisationUnit c = new OrganisationUnit();
		c.setOrganistaionUnitName("Keetmanshoop District");
		c.setOrganisationUnitCode("KD");
		OrganisationUnitLevel district = new OrganisationUnitLevel();
		district.setLevel(3);
		district.setName("District");
		c.setOrganisationUnitLevel(district);
		//c.setParent(b);
		c.setParentId(2);
		orgUnitList.add(c);
		
		OrganisationUnit d = new OrganisationUnit();
		d.setOrganistaionUnitName("Aus Clinic");
		d.setOrganisationUnitCode("AUS");
		OrganisationUnitLevel facility = new OrganisationUnitLevel();
		facility.setLevel(4);
		facility.setName("Facility");
		d.setOrganisationUnitLevel(facility);
		//c.setParent(b);
		d.setParentId(3);
		orgUnitList.add(d);
		
		OrganisationUnit e = new OrganisationUnit();
		e.setOrganistaionUnitName("Elizabeth Bay Clinic");
		e.setOrganisationUnitCode("EBC");
		e.setOrganisationUnitLevel(facility);
		//c.setParent(b);
		e.setParentId(3);
		orgUnitList.add(e);
		
		return orgUnitList;
	}
	
	public static List<ServiceType> generateServiceTypes(){
		
		List<ServiceType> serviceTypes = new ArrayList<ServiceType>();
		ServiceType antenatal = new ServiceType();
		antenatal.setName("Antenatal");
		serviceTypes.add(antenatal);
		ServiceType fp = new ServiceType();
		fp.setName("Family Planning");
		serviceTypes.add(fp);
		ServiceType cp = new ServiceType();
		cp.setName("Condom promotion and distribution");
		serviceTypes.add(cp);
		
		return serviceTypes;
		
	}
}
