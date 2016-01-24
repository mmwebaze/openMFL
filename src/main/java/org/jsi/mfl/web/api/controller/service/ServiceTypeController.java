package org.jsi.mfl.web.api.controller.service;

import javax.annotation.Resource;

import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.service.servicetype.ServiceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceTypeController {
	
	@Resource
	private ServiceTypeService serviceTypeService;
	
	@RequestMapping(value="/addService", method=RequestMethod.GET)
	public String addServiceForm(Model model){
		
		model.addAttribute("serviceType", new ServiceType());
		
		return "manageServices";
	}
	@RequestMapping(value="/submitService", method=RequestMethod.POST)
	public String addService(@ModelAttribute ServiceType serviceType){
		System.out.println("***************** "+serviceType);
		serviceTypeService.addServiceType(serviceType);
		return "redirect:/addService";
	}

}