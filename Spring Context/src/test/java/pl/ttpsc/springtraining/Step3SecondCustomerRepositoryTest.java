package pl.ttpsc.springtraining;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import pl.ttpsc.springtraining.Step3SecondCustomerRepositoryTest.TestSpecificConfig;
import pl.ttpsc.springtraining.core.AppRepository;
import pl.ttpsc.springtraining.core.BeanUtil;
import pl.ttpsc.springtraining.customer.Customer;
import pl.ttpsc.springtraining.customer.CustomerRepository;
import pl.ttpsc.springtraining.customer.CustomerSecondRepositoryImpl;
import pl.ttpsc.springtraining.customer.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringTrainingApplication.class, TestSpecificConfig.class })
public class Step3SecondCustomerRepositoryTest {

	@Configuration
	public static class TestSpecificConfig {

	}

	private @Autowired CustomerService customerService;
	private @Autowired @Qualifier("cust2repo") CustomerRepository customerRepository;

	@Test
	public void shouldHaveDifferentInstancesOfCustomerRepository() {
		AppRepository<Customer> repository = customerService.getRepository();
		assertThat(repository).isNotSameAs(customerRepository);
	}

	@Test
	public void shouldReturnInstanceOf() {
		CustomerSecondRepositoryImpl service = BeanUtil.getService(CustomerSecondRepositoryImpl.class);
		assertThat(service).isSameAs(customerRepository);
	}

}
