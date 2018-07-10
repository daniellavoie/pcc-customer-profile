package io.pivotal.pcc.customerprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pivotal.pcc.customerprofile.LoadCustomerProfileAudit;

public interface LoadCustomerProfileAuditJpaRepository extends JpaRepository<LoadCustomerProfileAudit, Long> {

}
