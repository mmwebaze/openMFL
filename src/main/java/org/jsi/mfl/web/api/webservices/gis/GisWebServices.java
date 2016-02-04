package org.jsi.mfl.web.api.webservices.gis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.jsi.mfl.api.service.organisationunit.OrganisationUnitService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GisWebServices {
	@Resource
	private OrganisationUnitService organisationUnitService;

	@RequestMapping("/api/geoJson/{ids}")
	public String getGeoJson(@PathVariable String ids){
		List <String> geos = organisationUnitService.getOrganisationUnitGeojsonById(ids);
		/*for (String s : geos)
			System.out.println(s);*/
		String str = StringUtils.join(geos);
		System.out.println(str);
		 return StringUtils.join(geos);
	}
}
