package org.jsi.mfl.api.domain.organisationunit;

public class OrganisationUnitWrapper {
	private int id;
	private String uuid;
	private String organisationUnitName;
	private String organisationUnitCode;
	private Boolean operationalStatus;
	private String ownerName;
	private String typeName;
	private String name;
	private int parentId;
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public OrganisationUnitWrapper(int id, String uuid,
			String organisationUnitName, String organisationUnitCode,
			Boolean operationalStatus,String ownerName, String typeName, String name, int parentId) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.organisationUnitName = organisationUnitName;
		this.organisationUnitCode = organisationUnitCode;
		this.operationalStatus = operationalStatus;
		this.ownerName = ownerName;
		this.typeName = typeName;
		this.name = name;
		this.parentId = parentId;
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
	public String getOrganisationUnitName() {
		return organisationUnitName;
	}
	public void setOrganisationUnitName(String organisationUnitName) {
		this.organisationUnitName = organisationUnitName;
	}
	public String getOrganisationUnitCode() {
		return organisationUnitCode;
	}
	public void setOrganisationUnitCode(String organisationUnitCode) {
		this.organisationUnitCode = organisationUnitCode;
	}
	public Boolean getOperationalStatus() {
		return operationalStatus;
	}
	public void setOperationalStatus(Boolean operationalStatus) {
		this.operationalStatus = operationalStatus;
	}
	@Override
	public String toString() {
		return "OrganisationUnitWrapper [id=" + id + ", uuid=" + uuid
				+ ", organisationUnitName=" + organisationUnitName
				+ ", organisationUnitCode=" + organisationUnitCode
				+ ", operationalStatus=" + operationalStatus + ", ownerName="
				+ ownerName + ", typeName=" + typeName + ", name=" + name
				+ ", parentId=" + parentId + "]";
	}
}
