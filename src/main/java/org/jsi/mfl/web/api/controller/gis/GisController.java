package org.jsi.mfl.web.api.controller.gis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GisController {
	
	
	@RequestMapping(value="/mapview", method=RequestMethod.POST)
	public String viewMap(@RequestParam("coordinates") String coordinates,  Model model){
		
		model.addAttribute("coordinates",coordinates);
		return "mapview";
	}
}
