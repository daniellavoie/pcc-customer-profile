package io.pivotal.pcc.customerprofile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.pcc.customerprofile.repository.LoadCustomerProfileAuditJpaRepository;

@RestController
@RequestMapping("/audit")
public class AuditController {
	private LoadCustomerProfileAuditJpaRepository dbRepository;

	public AuditController(LoadCustomerProfileAuditJpaRepository dbRepository) {
		this.dbRepository = dbRepository;
	}

	@GetMapping
	public Page<LoadCustomerProfileAudit> findAll(Pageable pageable) {
		return dbRepository.findAll(pageable);
	}
}
