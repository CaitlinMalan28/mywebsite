package za.co.shinysneaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return service.create(customer);
    }

    @GetMapping("/read/{customerid}")
    public Customer read(@PathVariable String customerid){
        return service.read(customerid);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return service.update(customer);
    }

    @DeleteMapping("/delete/{customerid}")
    public boolean delete(@PathVariable String customerid){
        return service.delete(customerid);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return service.getAll();
    }
}

