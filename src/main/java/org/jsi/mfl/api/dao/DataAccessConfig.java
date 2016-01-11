package org.jsi.mfl.api.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class DataAccessConfig {
	
	@PersistenceContext
	protected EntityManager entityManager;
	@Autowired
	protected DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
