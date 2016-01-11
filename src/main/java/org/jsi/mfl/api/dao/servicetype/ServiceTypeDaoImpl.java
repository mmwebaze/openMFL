package org.jsi.mfl.api.dao.servicetype;

import java.util.List;

import javax.transaction.Transactional;

import org.jsi.mfl.api.dao.DataAccessConfig;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ServiceTypeDaoImpl extends DataAccessConfig implements ServiceTypeDAO{

	@Override
	public void addServiceType(ServiceType serviceType) {
		entityManager.persist(serviceType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceType> getServiceTypes() {
		return entityManager.createQuery("from ServiceType" ).getResultList();
	}

	@Override
	public void updateServiceType(ServiceType serviceType) {
		// TODO Auto-generated method stub
		
	}

}
