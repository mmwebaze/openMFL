package org.jsi.mfl.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Testjes")
public class Testje {
	public Testje( String testName){
		this.testId = 1;
		this.testName = testName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testId;
	private String testName;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}

}
