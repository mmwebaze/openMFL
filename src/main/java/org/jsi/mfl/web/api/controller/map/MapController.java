package org.jsi.mfl.web.api.controller.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {

	@RequestMapping(value="/mapview", method=RequestMethod.GET)
	public String updateOrganisationUnit(){
		System.out.println("generate map");
		
		
		return "mapview";
	}
}
