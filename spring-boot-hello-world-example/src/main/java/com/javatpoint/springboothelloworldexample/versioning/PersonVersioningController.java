package com.javatpoint.springboothelloworldexample.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
//uri versioning
	@GetMapping("v1/person")
	public Personv1 Personv1() {
		return new Personv1("Bob Charlie");
	}

	@GetMapping("v2/person")
	public Personv2 Personv2() {
		return new Personv2(new Name("Bob", "Charlie"));
	}
//request parameter versioning
	@GetMapping(value="/person/param",params="version=1")
	public Personv1 paramv1() {
		return new Personv1("Bob Charlie");
	}

	@GetMapping(value="/person/param",params="version=2")
	public Personv2 paramvv2() {
		return new Personv2(new Name("Bob", "Charlie"));
	}
//header versioning
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public Personv1 headerv1() {
		return new Personv1("Bob Charlie");
	}

	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public Personv2 headerv2() {
		return new Personv2(new Name("Bob", "Charlie"));
	}
//accept header versioning or mime type versioning or media type versioning (content negotiation)
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public Personv1 producesv1() {
		return new Personv1("Bob Charlie");
	}

	@GetMapping(value="/person/header",produces="application/vnd.company.app-v2+json")
	public Personv2 producesv2() {
		return new Personv2(new Name("Bob", "Charlie"));
	}

}
