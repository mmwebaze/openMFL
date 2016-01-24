package org.jsi.mfl.api.domain.servicetype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;

@Entity
public class ServiceType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String name;
	public ServiceType(){
		
	}
	public ServiceType(String name) {
		super();
		this.name = name;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="orgUnitServices")
	private Collection<OrganisationUnit> orgUnits = new ArrayList<OrganisationUnit>();
	
	public Collection<OrganisationUnit> getOrgUnits() {
		return orgUnits;
	}
	public void setOrgUnits(Collection<OrganisationUnit> orgUnits) {
		this.orgUnits = orgUnits;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	@Override
	public String toString() {
		return "ServiceType [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.id);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ServiceType other = (ServiceType) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
}
