package io.pivotal.pcc.customerprofile;

public interface CustomerProfileService {
	CustomerProfile findOne(String id);

	CustomerProfile save(CustomerProfile customerProfile);
}
