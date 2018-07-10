package io.pivotal.pcc.customerprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pivotal.pcc.customerprofile.CustomerProfile;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, String> {

}
