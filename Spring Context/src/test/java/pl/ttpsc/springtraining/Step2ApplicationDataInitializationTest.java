package pl.ttpsc.springtraining;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import pl.ttpsc.springtraining.configuration.AppConfiguration;
import pl.ttpsc.springtraining.customer.Customer;
import pl.ttpsc.springtraining.customer.CustomerRepository;
import pl.ttpsc.springtraining.sales.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class Step2ApplicationDataInitializationTest {

	private @Autowired SpringTrainingApplication app;

	private @Autowired @Qualifier("customerRepository") CustomerRepository customerRepository;

	@Test
	public void shouldPrintOneCustomer() {
		Collection<Customer> result = app.getActiveCustomers();
		assertThat(result).hasSize(1);
	}

	@Test
	public void shouldPrintOneOrderOfActiveCustomer() {
		Collection<Order> result = app.getActiveCustomers().stream().findFirst()
				.map(customer -> app.getCustomerOrders(customer)).orElse(Collections.emptyList());
		assertThat(result).hasSize(2);
	}

	@Test
	public void shouldImplementsInitializationBean() {
		assertThat(AppConfiguration.class).isInstanceOf(InitializingBean.class);
	}
}
