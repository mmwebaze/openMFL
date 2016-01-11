package org.jsi.mfl.api.service.servicetype;

import java.util.List;

import javax.annotation.Resource;

import org.jsi.mfl.api.dao.servicetype.ServiceTypeDAO;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.springframework.stereotype.Component;

@Component
public class ServiceTypeService {
	@Resource
	private ServiceTypeDAO serviceTypeDao;
	
	public void addServiceType(ServiceType serviceType){
		serviceTypeDao.addServiceType(serviceType);
	}
	public List<ServiceType> getServiceTypes(){
		
		return serviceTypeDao.getServiceTypes();
	}
	public void updateServiceType(ServiceType serviceType){
		
	}
}
