package org.jsi.mfl.web.api.controller.organisationunit;

import java.text.ParseException;
import java.util.Locale;

import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.springframework.format.Formatter;

public class ServiceTypeFormatter implements Formatter<ServiceType>{

	@Override
	public String print(ServiceType serviceType, Locale locale) {
		// TODO Auto-generated method stub
		return ""+serviceType.getId();
	}

	@Override
	public ServiceType parse(String id, Locale locale) throws ParseException {
		ServiceType serviceType = new ServiceType();
		serviceType.setId(Integer.parseInt(id));
		return serviceType;
	}

}
