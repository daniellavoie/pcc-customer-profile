package io.pivotal.pcc.customerprofile;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.pivotal.pcc.customerprofile.cache.LoadCustomerProfileAuditCacheEntry;
import io.pivotal.pcc.customerprofile.cache.LoadCustomerProfileAuditCacheRepository;
import io.pivotal.pcc.customerprofile.repository.CustomerProfileRepository;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProfileServiceImpl.class);

	private CustomerProfileRepository repository;
	private LoadCustomerProfileAuditCacheRepository auditCacheRepository;

	public CustomerProfileServiceImpl(CustomerProfileRepository repository,
			LoadCustomerProfileAuditCacheRepository auditCacheRepository) {
		this.repository = repository;
		this.auditCacheRepository = auditCacheRepository;
	}

	@Override
	@Cacheable("customer-profile")
	public CustomerProfile findOne(String id) {
		LOGGER.info("Loading from repository customer profile " + id + ".");

		LoadCustomerProfileAuditCacheEntry audit = auditCacheRepository
				.save(new LoadCustomerProfileAuditCacheEntry(0l, id, LocalDateTime.now(), null));

		Optional<CustomerProfile> customerProfile = repository.findById(id);

		auditCacheRepository.save(new LoadCustomerProfileAuditCacheEntry(audit.getId(), audit.getCustomerProfileId(),
				audit.getStartTimestamp(), LocalDateTime.now()));

		return customerProfile
				.orElseThrow(() -> new RuntimeException("Could not find a customer profile for " + id + "."));
	}

	@CachePut
	@Override
	public CustomerProfile save(CustomerProfile customerProfile) {
		return repository.save(customerProfile);
	}

}
