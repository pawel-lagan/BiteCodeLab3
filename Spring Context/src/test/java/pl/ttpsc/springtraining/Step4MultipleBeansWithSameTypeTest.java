package pl.ttpsc.springtraining;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import pl.ttpsc.springtraining.Step3SecondCustomerRepositoryTest.TestSpecificConfig;
import pl.ttpsc.springtraining.customer.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringTrainingApplication.class, TestSpecificConfig.class })
public class Step4MultipleBeansWithSameTypeTest {

	@Configuration
	public static class TestSpecificConfig {

	}

	private @Autowired @Qualifier("customerRepository") CustomerRepository customerRepository;
	private @Autowired @Qualifier("cust2repo") CustomerRepository customerRepository2;

	private List<CustomerRepository> allImplementations;

	@Test
	public void shouldHaveDifferentInstancesOfCustomerRepository() {
		assertThat(customerRepository).isNotSameAs(customerRepository2);
	}

	@Test
	public void shouldReturnInstanceOf() {
		assertThat(allImplementations).hasSize(2);
	}

}
