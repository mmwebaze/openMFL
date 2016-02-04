package org.jsi.mfl.util;

public class QueryUtil {

	public static String searchQuery(boolean exclude, int orgUnitTypeId){
		System.out.println(exclude);
		if (exclude == true){
			if (orgUnitTypeId == 0){
				return "select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnitWrapper(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus,  o.geoJson, w.ownerName, t.typeName, s.name, p.id as parentId) from OrganisationUnit o "
						+ "LEFT JOIN o.orgUnitOwner w LEFT JOIN o.orgUnitType t LEFT JOIN o.orgUnitServices s "
						+ "LEFT JOIN o.parent p where o.parent IS NOT NULL AND (o.organisationUnitCode  NOT LIKE :searchTerm OR UPPER(o.organisationUnitName) NOT LIKE UPPER(:searchTerm) OR UPPER(s.name) NOT LIKE UPPER(:searchTerm))";
			}
			else{
				return "select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnitWrapper(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus,  o.geoJson, w.ownerName, t.typeName, s.name, p.id as parentId) from OrganisationUnit o "
						+ "LEFT JOIN o.orgUnitOwner w LEFT JOIN o.orgUnitType t LEFT JOIN o.orgUnitServices s "
						+ "LEFT JOIN o.parent p where o.parent IS NOT NULL AND t.id = :id AND (o.organisationUnitCode  NOT LIKE :searchTerm OR UPPER(o.organisationUnitName) NOT LIKE UPPER(:searchTerm) OR UPPER(s.name) NOT LIKE UPPER(:searchTerm) )";
			}
			
			
		}
		else{
			if (orgUnitTypeId == 0){
				return "select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnitWrapper(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus,  o.geoJson, w.ownerName, t.typeName, s.name, p.id as parentId) from OrganisationUnit o "
						+ "LEFT JOIN o.orgUnitOwner w LEFT JOIN o.orgUnitType t LEFT JOIN o.orgUnitServices s "
						+ "LEFT JOIN o.parent p where o.parent IS NOT NULL AND (o.organisationUnitCode  LIKE :searchTerm OR UPPER(o.organisationUnitName) LIKE UPPER(:searchTerm) OR UPPER(s.name) LIKE UPPER(:searchTerm) )";
			}
			else{
				return "select NEW org.jsi.mfl.api.domain.organisationunit.OrganisationUnitWrapper(o.id, o.uuid, o.organisationUnitName, o.organisationUnitCode, o.operationalStatus,  o.geoJson, w.ownerName, t.typeName, s.name, p.id as parentId) from OrganisationUnit o "
						+ "LEFT JOIN o.orgUnitOwner w LEFT JOIN o.orgUnitType t LEFT JOIN o.orgUnitServices s "
						+ "LEFT JOIN o.parent p where o.parent IS NOT NULL AND t.id = :id AND (o.organisationUnitCode LIKE :searchTerm OR UPPER(o.organisationUnitName) LIKE UPPER(:searchTerm) OR UPPER(s.name) LIKE UPPER(:searchTerm) )";
			}
		}
	}
}
