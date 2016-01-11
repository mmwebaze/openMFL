package org.jsi.mfl.api.dao.servicetype;

import java.util.List;

import org.jsi.mfl.api.domain.servicetype.ServiceType;

public interface ServiceTypeDAO {

	public void addServiceType(ServiceType serviceType);
	public List<ServiceType> getServiceTypes();
	public void updateServiceType(ServiceType serviceType);
}
