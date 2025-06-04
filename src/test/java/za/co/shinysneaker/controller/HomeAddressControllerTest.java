package za.co.shinysneaker.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.domain.HomeAddress;
import za.co.shinysneaker.factory.CustomerFactory;
import za.co.shinysneaker.factory.HomeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class HomeAddressControllerTest {

    private static HomeAddress homeAddress;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/mywebsite/homeaddress";

    @BeforeEach
    void setUp() {
        homeAddress = HomeAddressFactory.createHomeAddress(
                "54",
                "Williams Ave",
                "Grassy Park",
                "Cape Town",
                "Western Cape",
                "South Africa",
                7888);
        restTemplate.postForObject(BASE_URL + "/create", homeAddress, HomeAddress.class);
    }

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<HomeAddress> postResponse = this.restTemplate.postForEntity(url, homeAddress, HomeAddress.class);
        assertNotNull(postResponse);
        HomeAddress homeAddressSaved = postResponse.getBody();
        assertEquals(homeAddress.getAddressId(), homeAddressSaved.getAddressId());
        System.out.println("Created: " + homeAddressSaved);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/{addressId}" + homeAddress.getAddressId();
        ResponseEntity<HomeAddress> response = this.restTemplate.getForEntity(url, HomeAddress.class);
        assertEquals(homeAddress.getAddressId(), response.getBody().getAddressId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void update() {
        HomeAddress updatedHomeAddress = new HomeAddress.Builder().copy(homeAddress)
                .setPostalCode(2589)
                .build();

        String url = BASE_URL + "/update";
        this.restTemplate.put(url, updatedHomeAddress);
        ResponseEntity<HomeAddress> response = restTemplate.getForEntity(
                BASE_URL + "/read/{addressId}" + updatedHomeAddress.getAddressId(), HomeAddress.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete/{addressId}" + homeAddress.getAddressId();
        this.restTemplate.delete(url);

        // Verify that the homeAddress was deleted
        ResponseEntity<HomeAddress> response = this.restTemplate.getForEntity(
                BASE_URL + "/read/{addressId}" + homeAddress.getAddressId(), HomeAddress.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted: " + true);
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        ResponseEntity<HomeAddress[]> response = this.restTemplate.getForEntity(url, HomeAddress[].class);
        assertNotNull(response.getBody());
        System.out.println("Get All: ");
        for (HomeAddress homeAddy : response.getBody()) {
            System.out.println(homeAddy);
        }
    }
}