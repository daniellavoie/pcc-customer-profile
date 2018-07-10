package io.pivotal.pcc.customerprofile;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.query.CqEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.gemfire.listener.annotation.ContinuousQuery;
import org.springframework.stereotype.Component;

import io.pivotal.pcc.customerprofile.cache.LoadCustomerProfileAuditCacheEntry;
import io.pivotal.pcc.customerprofile.repository.LoadCustomerProfileAuditJpaRepository;
import reactor.core.publisher.Mono;

@Component
public class LoadCustomerProfileAuditListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadCustomerProfileAuditListener.class);

	private LoadCustomerProfileAuditJpaRepository dbRepository;

	public LoadCustomerProfileAuditListener(GemFireCache gemFireCache,
			LoadCustomerProfileAuditJpaRepository dbRepository) {
		this.dbRepository = dbRepository;
	}

	@ContinuousQuery(name = "ApprovedDecisionsHandler", query = "SELECT * FROM /load-customer-profile-audit loadCustomerProfileAudit")
	public void processEvent(CqEvent cQevent) {
		Mono.just(cQevent)

				.filter(event -> event.getNewValue() instanceof LoadCustomerProfileAuditCacheEntry)

				.map(event -> event.getNewValue())

				.map(object -> (LoadCustomerProfileAuditCacheEntry) object)

				.map(cacheAudit -> new LoadCustomerProfileAudit(cacheAudit.getId(), cacheAudit.getCustomerProfileId(),
						cacheAudit.getStartTimestamp(), cacheAudit.getEndTimestamp()))

				.doOnNext(cacheAudit -> LOGGER.info("Persisting load customer profile audit to db."))

				.doOnNext(dbRepository::save)

				.doOnError(ex -> LOGGER.error("Error while persiting cache event to db.", ex))

				.subscribe();
	}
}
