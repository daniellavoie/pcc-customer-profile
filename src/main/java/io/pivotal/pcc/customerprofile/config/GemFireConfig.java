package io.pivotal.pcc.customerprofile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableLogging;
import org.springframework.geode.config.annotation.EnableDurableClient;
import org.springframework.geode.config.annotation.UseMemberName;

import io.pivotal.pcc.customerprofile.cache.LoadCustomerProfileAuditCacheEntry;

@Configuration
@EnableEntityDefinedRegions(basePackageClasses = { LoadCustomerProfileAuditCacheEntry.class })
@EnableCachingDefinedRegions
@EnableLogging(logLevel = "info")
@UseMemberName("customer-profile-service")
@EnableDurableClient(id = "customer-profile-service")
public class GemFireConfig {
	
}
