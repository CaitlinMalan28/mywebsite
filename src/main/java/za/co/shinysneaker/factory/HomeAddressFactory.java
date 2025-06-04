package za.co.shinysneaker.factory;

import za.co.shinysneaker.domain.HomeAddress;
import za.co.shinysneaker.util.Helper;

public class HomeAddressFactory {

    public static HomeAddress createHomeAddress(
            String streetNumber,
            String streetName,
            String suburb,
            String city,
            String province,
            String country,
            int postalCode
    ) {
        if (!Helper.isValidPostalCode(postalCode))
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);

        if (!Helper.isValidStreetNumber(streetNumber))
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);

        return new HomeAddress.Builder()
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setProvince(province)
                .setCountry(country)
                .setPostalCode(postalCode)
                .build();
    }
}
