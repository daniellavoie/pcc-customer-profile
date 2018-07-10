package io.pivotal.pcc.customerprofile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-profile")
public class CustomerProfileController {
	private CustomerProfileService service;

	public CustomerProfileController(CustomerProfileService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public CustomerProfile findOne(@PathVariable String id) {
		return service.findOne(id);
	}
}
