package za.co.shinysneaker.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.factory.CustomerFactory;
import za.co.shinysneaker.factory.HomeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

        @Autowired
        private ICustomerService service;
        private Customer customer;

        @BeforeEach
        void setUp() {
            Customer customerList = CustomerFactory.createCustomer(
                    "Smith",
                    "Paul",
                    "065 488 1782",
                    "john@gmail.com",

                    HomeAddressFactory.createHomeAddress(
                            "54",
                            "Williams Ave",
                            "Grassy Park",
                            "Cape Town",
                            "Western Cape",
                            "South Africa",
                            7888)
                    );
            this.customer = service.create(customerList);
            assertNotNull(customer);
            assertNotNull(customer.getCustomerId());
        }

        @Test
        @Order(1)
        void create() {
            Customer newCustomer = service.create(customer);
            assertNotNull(newCustomer);
            assertNotNull(newCustomer.getCustomerId());
            System.out.println(newCustomer);
        }

        @Test
        @Order(2)
        void read() {
            Customer read = service.read(customer.getCustomerId());
            assertNotNull(read);
            assertNotNull(read.getCustomerId());
            System.out.println(read);
        }

        @Test
        @Order(3)
        void update() {
            Customer updateBook = new Customer.Builder().copy(customer).setFirstName("Penny").build();
            Customer updated = service.update(updateBook);
            assertNotNull(updated);
            assertNotNull(updated.getCustomerId());
            System.out.println(updated);
        }

        @Test
        @Order(4)
        void delete() {
            boolean deleteCustomer = service.delete(customer.getCustomerId());
            assertTrue(deleteCustomer);
        }

        @Test
        @Order(5)
        void getAll() {
            System.out.println(service.getAll());
        }
}