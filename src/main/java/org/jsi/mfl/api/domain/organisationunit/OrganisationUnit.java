package org.jsi.mfl.api.domain.organisationunit;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organisationunit")
public class OrganisationUnit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String uuid;
	private String organistaionUnitName;
	private String organisationUnitCode;
	private int organistionUnitLevel;
	//private OrganisationUnit parent;
	//private Set<OrganisationUnit> organistionUnitChildren;
	
	public OrganisationUnit()
    {
        this.uuid = UUID.randomUUID().toString();
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getOrganistaionUnitName() {
		return organistaionUnitName;
	}
	public void setOrganistaionUnitName(String organistaionUnitName) {
		this.organistaionUnitName = organistaionUnitName;
	}
	public String getOrganisationUnitCode() {
		return organisationUnitCode;
	}
	public void setOrganisationUnitCode(String organisationUnitCode) {
		this.organisationUnitCode = organisationUnitCode;
	}
	public int getOrganistionUnitLevel() {
		return organistionUnitLevel;
	}
	public void setOrganistionUnitLevel(int organistionUnitLevel) {
		this.organistionUnitLevel = organistionUnitLevel;
	}
	/*public OrganisationUnit getParent() {
		return parent;
	}
	public void setParent(OrganisationUnit parent) {
		this.parent = parent;
	}*/
	/*public Set getOrganistionUnitChildren() {
		return organistionUnitChildren;
	}
	public void setOrganistionUnitChildren(Set organistionUnitChildren) {
		this.organistionUnitChildren = organistionUnitChildren;
	}*/
}
