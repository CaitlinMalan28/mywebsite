package za.co.shinysneaker.factory;

import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.domain.HomeAddress;
import za.co.shinysneaker.util.Helper;

import java.util.Random;

public class  CustomerFactory {

    public static Customer createCustomer(
            String firstName,
            String lastName,
            String mobile,
            String email,
            String streetNumber,
            String streetName,
            String suburb,
            String city,
            String province,
            String country,
            int postalCode
    ) {
        String customerId = Helper.generateId(); // give random String
        Long addressId = new Random().nextLong();

        if (Helper.NullOrEmpty(firstName) || Helper.NullOrEmpty(lastName) || Helper.NullOrEmpty(mobile) || Helper.NullOrEmpty(email)){
            System.out.println("Information missing");
        }

        if (!Helper.isValidPostalCode(postalCode))
            return null;

        if (!Helper.isValidStreetNumber(streetNumber))
            return null;

        if (!Helper.isValidEmail(email))
            return null;

        HomeAddress homeAddress = new HomeAddress.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setSuburb(suburb)
                .setCity(city)
                .setProvince(province)
                .setPostalCode(postalCode)
                .build();

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobile(mobile)
                .setEmail(email)
                .setHomeAddress(homeAddress)
                .build();
    }

    public static Customer createCustomer(
            String firstName,
            String lastName,
            String mobile,
            String email,
            HomeAddress homeAddress
    ) {

        String customerId = Helper.generateId();

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobile(mobile)
                .setEmail(email)
                .setHomeAddress(homeAddress)
                .build();
    }
}
