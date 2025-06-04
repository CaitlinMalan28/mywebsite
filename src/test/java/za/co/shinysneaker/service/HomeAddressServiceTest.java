package za.co.shinysneaker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.domain.HomeAddress;
import za.co.shinysneaker.factory.CustomerFactory;
import za.co.shinysneaker.factory.HomeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HomeAddressServiceTest {

    @Autowired
    private IHomeAddressService service;
    private HomeAddress homeAddress;

    @BeforeEach
    void setUp() {
        HomeAddress homeAddressList = HomeAddressFactory.createHomeAddress(
                "54",
                "Williams Ave",
                "Grassy Park",
                "Cape Town",
                "Western Cape",
                "South Africa",
                7888);
        this.homeAddress = service.create(homeAddressList);
        assertNotNull(homeAddress);
        assertNotNull(homeAddress.getAddressId());
    }

    @Test
    void create() {
        HomeAddress newHomeAddress = service.create(homeAddress);
        assertNotNull(newHomeAddress);
        assertNotNull(newHomeAddress.getAddressId());
        System.out.println(newHomeAddress);
    }

    @Test
    void read() {
        HomeAddress read = service.read(homeAddress.getAddressId());
        assertNotNull(read);
        assertNotNull(read.getAddressId());
        System.out.println(read);
    }

    @Test
    void update() {
        HomeAddress updateHomeAddress = new HomeAddress.Builder().copy(homeAddress).setStreetName("Bass").build();
        HomeAddress updated = service.update(updateHomeAddress);
        assertNotNull(updated);
        assertNotNull(updated.getAddressId());
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean deleteAddress = service.delete(homeAddress.getAddressId());
        assertTrue(deleteAddress);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}