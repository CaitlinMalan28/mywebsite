package za.co.shinysneaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.repository.CustomerRepository;
import za.co.shinysneaker.repository.HomeAddressRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private CustomerRepository repository;

    @Autowired CustomerService(CustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);    }

    @Override
    public Customer read(String string) {
        return this.repository.findById(string).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public boolean delete(String string) {
        this.repository.deleteById(string);
        return true;
    }

    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }
}
