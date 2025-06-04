package za.co.shinysneaker.factory;

import org.junit.jupiter.api.Test;
import za.co.shinysneaker.domain.HomeAddress;

import static org.junit.jupiter.api.Assertions.*;

class HomeAddressFactoryTest {

    @Test
    void createHomeAddress() {
        HomeAddress homeAddress = HomeAddressFactory.createHomeAddress(
                "54",
                "Williams Ave",
                "Grassy Park",
                "Cape Town",
                "Western Cape",
                "South Africa",
                7888);

        assertNotNull(homeAddress);
        System.out.println(homeAddress);
    }

    @Test
    void createHomeAddressWithInvalidPostalCode() {
        HomeAddress homeAddress = HomeAddressFactory.createHomeAddress(
                "54",
                "Williams Ave",
                "Grassy Park",
                "Cape Town",
                "Western Cape",
                "South Africa",
                88);
        assertNotNull(homeAddress);
        System.out.println(homeAddress);
    }


}