package io.pivotal.pcc.customerprofile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.pivotal.pcc.customerprofile.repository.CustomerProfileRepository;

@SpringBootApplication
public class PccCustomerProfileApplication implements CommandLineRunner {
	@Autowired
	private CustomerProfileRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PccCustomerProfileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.saveAll(IntStream.range(1, 1000)
				.mapToObj(i -> new CustomerProfile(i + "", "Daniel", "Lavoie", "dlavoie@pivotal.io"))
				.collect(Collectors.toList()));
	}
}
