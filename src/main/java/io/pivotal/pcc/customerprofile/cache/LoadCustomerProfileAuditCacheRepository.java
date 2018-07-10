package io.pivotal.pcc.customerprofile.cache;

import org.springframework.data.gemfire.repository.GemfireRepository;

public interface LoadCustomerProfileAuditCacheRepository
		extends GemfireRepository<LoadCustomerProfileAuditCacheEntry, Long> {

}
