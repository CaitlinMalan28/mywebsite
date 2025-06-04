package za.co.shinysneaker.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.factory.CustomerFactory;
import za.co.shinysneaker.factory.HomeAddressFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    private static Customer customer;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/customer";

    @BeforeAll
    public static void setUp() {
        customer = CustomerFactory.createCustomer(
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
    }

    @Test
    void a_create() {
        Customer createCustomer = restTemplate.postForObject(BASE_URL+"/create",customer,Customer.class);
        assertNotNull(createCustomer);
        System.out.println(createCustomer);
    }

    @Test
    void read() {
        Customer readCustomer = restTemplate.getForObject(BASE_URL+"/read/{customerid}",Customer.class,customer.getCustomerId());
        assertNotNull(customer.getCustomerId());
        assertNotNull(readCustomer);
        System.out.println(readCustomer);
    }

    @Test
    void update() {
        Customer updatedCustomer = new Customer.Builder().copy(customer).setFirstName("Rick").build();
        Customer updated =  restTemplate.postForObject(BASE_URL+"/update",updatedCustomer,Customer.class);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        restTemplate.delete(BASE_URL+"/delete/{customerid}",customer.getCustomerId());

        Customer readCustomer = restTemplate.getForObject(BASE_URL+"/read/{customerid}",Customer.class,customer.getCustomerId());
        assertNotNull(readCustomer);
        System.out.println(readCustomer);
    }

    @Test
    void getAll() {
        System.out.println(restTemplate.getForObject(BASE_URL+"/getAll", List.class));
    }
}

