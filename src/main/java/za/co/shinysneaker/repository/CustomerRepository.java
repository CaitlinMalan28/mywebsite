package za.co.shinysneaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.shinysneaker.domain.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);

    Customer findByMobile(String mobileNumber);

    List<Customer> findAllCustomersByLastName(String lastName);

    Customer findByFirstNameAndLastName(String firstName, String lastName);

    List<Customer> findByLastName(String lastName);

    //Finding the list of customers with a certain last name and filter the list with all the customers that live in the same suburb

}

