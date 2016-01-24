package org.jsi.mfl.api.domain.organisationunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.BatchSize;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.domain.user.User;


@Entity
@Table(name="organisationunit", uniqueConstraints = {@UniqueConstraint(columnNames = {"uuid","organisationUnitCode"})})
public class OrganisationUnit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String uuid;
	private String organisationUnitName;
	private String organisationUnitCode;
	private Boolean operationalStatus;
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade={CascadeType.ALL})
    @JoinColumn(name="parentId")
	@BatchSize(size=1)
	private OrganisationUnit parent;
	@Column(name="geojson", columnDefinition="TEXT")
	private String geoJson;
	public String getGeoJson() {
		return geoJson;
	}

	public void setGeoJson(String geoJson) {
		this.geoJson = geoJson;
	}

	public OrganisationUnit getParent() {
		return parent;
	}

	public void setParent(OrganisationUnit parent) {
		this.parent = parent;
	}
	@Transient
	private int orgUnitTypeId;
	
	public int getOrgUnitTypeId() {
		return orgUnitTypeId;
	}

	public void setOrgUnitTypeId(int orgUnitTypeId) {
		this.orgUnitTypeId = orgUnitTypeId;
	}
	@Transient
	private String ownerName; 
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@Transient
	private int idParent;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name="owner_orgunit", 
    joinColumns={@JoinColumn(name="orgunit_id")}, 
    inverseJoinColumns={@JoinColumn(name="owner_id")})
	private OrganisationUnitOwner orgUnitOwner;
	public OrganisationUnitOwner getOrgUnitOwner() {
		return orgUnitOwner;
	}

	public void setOrgUnitOwner(OrganisationUnitOwner orgUnitOwner) {
		this.orgUnitOwner = orgUnitOwner;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name="orgunit_type", 
    joinColumns={@JoinColumn(name="orgunit_id")}, 
    inverseJoinColumns={@JoinColumn(name="orgtype_id")})
	private OrganisationUnitType orgUnitType;
	
	public OrganisationUnitType getOrgUnitType() {
		return orgUnitType;
	}

	public void setOrgUnitType(OrganisationUnitType orgUnitType) {
		this.orgUnitType = orgUnitType;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public void setOrgUnitServices(Collection<ServiceType> orgUnitServices) {
		this.orgUnitServices = orgUnitServices;
	}

	public Boolean getOperationalStatus() {
		return operationalStatus;
	}

	public void setOperationalStatus(Boolean operationalStatus) {
		this.operationalStatus = operationalStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = {CascadeType.ALL})
	@JoinTable(name="orgunit_level", 
    joinColumns={@JoinColumn(name="orgunit_id")}, 
    inverseJoinColumns={@JoinColumn(name="level_id")})
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

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private Collection<User> users = new ArrayList<User>();
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name="orgunit_service", 
    joinColumns={@JoinColumn(name="orgunit_id")}, 
    inverseJoinColumns={@JoinColumn(name="service_id")})
	private Collection<ServiceType> orgUnitServices = new ArrayList<ServiceType>();
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@OneToMany
	private Set<OrganisationUnit> organisationUnitChildren;
	
	public Set<OrganisationUnit> getOrganisationUnitChildren() {
		return organisationUnitChildren;
	}

	public void setOrganisationUnitChildren(
			Set<OrganisationUnit> organisationUnitChildren) {
		this.organisationUnitChildren = organisationUnitChildren;
	}

	public OrganisationUnit()
    {
        this.uuid = UUID.randomUUID().toString();
    }
	public OrganisationUnit(int id, String uuid, String organisationUnitName, String organisationUnitCode, Boolean operationalStatus, String ownerName){
		this.id = id;
		this.uuid = uuid;
		this.organisationUnitName = organisationUnitName;
		this.organisationUnitCode = organisationUnitCode;
		this.operationalStatus = operationalStatus;
		this.ownerName = ownerName;
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
	
	public String getOrganisationUnitCode() {
		return organisationUnitCode;
	}
	public void setOrganisationUnitCode(String organisationUnitCode) {
		this.organisationUnitCode = organisationUnitCode;
	}

	public String getOrganisationUnitName() {
		return organisationUnitName;
	}

	public void setOrganisationUnitName(String organisationUnitName) {
		this.organisationUnitName = organisationUnitName;
	}

	@Override
	public String toString() {
		return "OrganisationUnit [id=" + id + ", uuid=" + uuid
				+ ", organisationUnitName=" + organisationUnitName
				+ ", organisationUnitCode=" + organisationUnitCode
				+ ", operationalStatus=" + operationalStatus + ", parent="
				+ parent + ", idParent=" + idParent + ", orgUnitType="
				+ orgUnitType + ", organisationUnitLevel="
				+ organisationUnitLevel + ", orgUnitServices="
				+ orgUnitServices + "]";
	}
}
