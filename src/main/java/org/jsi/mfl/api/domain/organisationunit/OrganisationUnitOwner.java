package org.jsi.mfl.api.domain.organisationunit;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;

@Entity
public class OrganisationUnitOwner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String ownerName;
	private String ownerDescription;
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="orgUnitOwner")
	private Collection<OrganisationUnit> organisationUnit = new ArrayList<OrganisationUnit>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerDescription() {
		return ownerDescription;
	}
	public void setOwnerDescription(String ownerDescription) {
		this.ownerDescription = ownerDescription;
	}
	@Override
	public String toString() {
		return "OrganisationUnitOwner [id=" + id + ", ownerName=" + ownerName
				+ ", ownerDescription=" + ownerDescription + "]";
	}
}
