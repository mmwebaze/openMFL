package org.jsi.mfl.api.domain.organisationunit;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(name="orgunitByLevel",
entities=@EntityResult(entityClass=LevelMapping.class,
fields = {
	@FieldResult(name="id", column = "id"),
	@FieldResult(name="orgUnitName", column = "organisationunitname"),
	@FieldResult(name="levelName", column = "name"),
}))
public class LevelMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String orgUnitName;
	private String levelName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrgUnitName() {
		return orgUnitName;
	}
	public void setOrgUnitName(String orgUnitName) {
		this.orgUnitName = orgUnitName;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	@Override
	public String toString() {
		return "LevelMapping [id=" + id + ", orgUnitName=" + orgUnitName
				+ ", levelName=" + levelName + "]";
	}
}
