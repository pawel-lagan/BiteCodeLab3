package pl.ttpsc.springtraining;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import pl.ttpsc.springtraining.core.AppRepository;
import pl.ttpsc.springtraining.core.BeanUtil;
import pl.ttpsc.springtraining.customer.Customer;
import pl.ttpsc.springtraining.customer.CustomerRepository;
import pl.ttpsc.springtraining.customer.CustomerRepositoryImpl;
import pl.ttpsc.springtraining.customer.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class Step1ContextInitializationTest {

	private @Autowired ApplicationContext context;

	private @Autowired CustomerService customerService;
	private @Autowired @Qualifier("customerRepository") CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
		assertThat(context).isNotNull();
	}

	@Test
	public void shouldHaveSameInstanceOfCustomerRepository() {
		AppRepository<Customer> repository = customerService.getRepository();
		assertThat(repository).isSameAs(customerRepository);
	}

	@Test
	public void shouldReturnInstanceOf() {
		CustomerRepositoryImpl service = BeanUtil.getService(CustomerRepositoryImpl.class);
		assertThat(service).isSameAs(customerRepository);
	}

	@Test
	public void shouldReturnInstanceOfByGenericInterface() {
		AppRepository<Customer> serviceByResolvable = BeanUtil.getServiceByGeneric(AppRepository.class, Customer.class);
		assertThat(serviceByResolvable).isSameAs(customerRepository);
	}

}
