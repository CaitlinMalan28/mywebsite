package za.co.shinysneaker.factory;

import org.junit.jupiter.api.Test;
import za.co.shinysneaker.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    public void testCreateBook() {
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
        assertNotNull(customerList);
        System.out.println(customerList.toString());
    }

    @Test
    void Customer_FirstNameNullOrEmpty(){
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
        assertNotNull(customerList);
        assertEquals("",customerList.getFirstName());
    }
    @Test
    void Customer_LastNameNullOrEmpty(){
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
        assertNotNull(customerList);
        assertEquals("",customerList.getLastName());
    }
    @Test
    void Customer_MobileNullOrEmpty(){
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
        assertNotNull(customerList);
        assertEquals("",customerList.getMobile());
    }
    @Test
    void Customer_EmailNullOrEmpty() {
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
        assertNotNull(customerList);
        assertEquals("", customerList.getEmail());
    }
    @Test
    void Customer_EmailInvalid(){
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
        assertNotNull(customerList);
    }

}