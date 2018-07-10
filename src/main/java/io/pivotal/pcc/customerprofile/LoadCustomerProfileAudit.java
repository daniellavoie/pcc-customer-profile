package io.pivotal.pcc.customerprofile;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoadCustomerProfileAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String customerProfileId;
	private LocalDateTime startTimestamp;
	private LocalDateTime endTimestamp;

	public LoadCustomerProfileAudit() {

	}

	public LoadCustomerProfileAudit(Long id, String customerProfileId, LocalDateTime startTimestamp,
			LocalDateTime endTimestamp) {
		this.id = id;
		this.customerProfileId = customerProfileId;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerProfileId() {
		return customerProfileId;
	}

	public void setCustomerProfileId(String customerProfileId) {
		this.customerProfileId = customerProfileId;
	}

	public LocalDateTime getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(LocalDateTime startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public LocalDateTime getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(LocalDateTime endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
}
