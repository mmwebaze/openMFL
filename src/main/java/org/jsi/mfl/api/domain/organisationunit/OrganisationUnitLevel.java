package org.jsi.mfl.api.domain.organisationunit;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="orgunitlevel", uniqueConstraints = {@UniqueConstraint(columnNames = {"level","name","uuid","code"})})

public class OrganisationUnitLevel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//@Column(nullable=false)
	private int level;
	//@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String uuid;
	//@Column(nullable=true)
	
	private String code;
	public OrganisationUnitLevel(int id) {
		super();
		this.id = id;
	}
	public OrganisationUnitLevel(int id, String uuid, String name){
		this.id = id;
		this.uuid = uuid;
		this.name = name;
	}
	public OrganisationUnitLevel(){
		//this.uuid = UUID.randomUUID().toString();
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="organisationUnitLevel")
	private Collection<OrganisationUnit> organisationUnit = new ArrayList<OrganisationUnit>();
	
	public Collection<OrganisationUnit> getOrganisationUnit() {
		return organisationUnit;
	}
	public void setOrganisationUnit(Collection<OrganisationUnit> organisationUnit) {
		this.organisationUnit = organisationUnit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "OrganisationUnitLevel [id=" + id + ", level=" + level
				+ ", name=" + name + ", uuid=" + uuid + ", code=" + code + "]";
	}
	
}
