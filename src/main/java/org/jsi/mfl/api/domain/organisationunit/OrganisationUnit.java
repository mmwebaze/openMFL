package org.jsi.mfl.api.domain.organisationunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.domain.user.User;

@Entity
@Table(name="organisationunit", uniqueConstraints = {@UniqueConstraint(columnNames = {"uuid","organisationUnitCode"})})
public class OrganisationUnit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String uuid;
	private String organistaionUnitName;
	private String organisationUnitCode;
	private Boolean operationalStatus;
	public Boolean getOperationalStatus() {
		return operationalStatus;
	}

	public void setOperationalStatus(Boolean operationalStatus) {
		this.operationalStatus = operationalStatus;
	}
	@ManyToOne(cascade = {CascadeType.ALL})
	private OrganisationUnitLevel organisationUnitLevel;
	public OrganisationUnitLevel getOrganisationUnitLevel() {
		return organisationUnitLevel;
	}

	public void setOrganisationUnitLevel(OrganisationUnitLevel organisationUnitLevel) {
		this.organisationUnitLevel = organisationUnitLevel;
	}

	public Collection<ServiceType> getOrgUnitServices() {
		return orgUnitServices;
	}

	public void setOrgUnitServices(Collection<ServiceType> orgUnitServices) {
		this.orgUnitServices = orgUnitServices;
	}
	//private int organistionUnitLevel;
	private int parentId;
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<User> users = new ArrayList<User>();
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<ServiceType> orgUnitServices = new ArrayList<ServiceType>();
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	/*@OneToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name="id")
	private OrganisationUnit parent;*/
	//private Set<OrganisationUnit> organistionUnitChildren;
	
	public OrganisationUnit()
    {
        this.uuid = UUID.randomUUID().toString();
    }
/*	public OrganisationUnit(OrganisationUnit parent){
		this.uuid = UUID.randomUUID().toString();
		this.parentId = parent.getId();
		System.out.println("*** ID "+parent.getId());
	}*/
	
	/*public OrganisationUnit getParent() {
		return parent;
	}

	public void setParent(OrganisationUnit parent) {
		this.parent = parent;
	}*/

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
	/*public int getOrganistionUnitLevel() {
		return organistionUnitLevel;
	}
	public void setOrganistionUnitLevel(int organistionUnitLevel) {
		this.organistionUnitLevel = organistionUnitLevel;
	}*/
	/*public Set getOrganistionUnitChildren() {
		return organistionUnitChildren;
	}
	public void setOrganistionUnitChildren(Set organistionUnitChildren) {
		this.organistionUnitChildren = organistionUnitChildren;
	}*/

	@Override
	public String toString() {
		return "OrganisationUnit [uuid=" + uuid + ", organistaionUnitName="
				+ organistaionUnitName + ", organisationUnitCode="
				+ organisationUnitCode + ", operationalStatus="
				+ operationalStatus + ", organisationUnitLevel="
				+ organisationUnitLevel + ", parentId=" + parentId + ", users="
				+ users + ", orgUnitServices=" + orgUnitServices + "]";
	}
}
