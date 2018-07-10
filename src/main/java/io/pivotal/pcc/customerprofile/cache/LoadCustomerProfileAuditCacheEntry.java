package io.pivotal.pcc.customerprofile.cache;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("load-customer-profile-audit")
public class LoadCustomerProfileAuditCacheEntry {
	@Id
	private final Long id;

	private final String customerProfileId;
	private final LocalDateTime startTimestamp;
	private final LocalDateTime endTimestamp;

	public LoadCustomerProfileAuditCacheEntry(Long id, String customerProfileId, LocalDateTime startTimestamp,
			LocalDateTime endTimestamp) {
		this.id = id;
		this.customerProfileId = customerProfileId;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
	}

	public Long getId() {
		return id;
	}

	public String getCustomerProfileId() {
		return customerProfileId;
	}

	public LocalDateTime getStartTimestamp() {
		return startTimestamp;
	}

	public LocalDateTime getEndTimestamp() {
		return endTimestamp;
	}
}
