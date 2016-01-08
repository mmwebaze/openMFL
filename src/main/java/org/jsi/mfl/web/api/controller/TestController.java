package org.jsi.mfl.web.api.controller;

import org.jsi.mfl.api.domain.Testje;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/greeting/{name}")
    public Testje greeting(@PathVariable String name) {
		System.out.println("************ "+name);
        return new Testje(name);
    }
}
