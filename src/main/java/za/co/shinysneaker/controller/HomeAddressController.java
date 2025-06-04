package za.co.shinysneaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.domain.HomeAddress;
import za.co.shinysneaker.service.CustomerService;
import za.co.shinysneaker.service.HomeAddressService;

import java.util.List;

@RestController
@RequestMapping("/homeaddress")
public class HomeAddressController {

    private HomeAddressService service;

    @Autowired
    public HomeAddressController(HomeAddressService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public HomeAddress create(@RequestBody HomeAddress homeAddress) {
        return service.create(homeAddress);
    }

    @GetMapping("/read/{addressId}")
    public HomeAddress read(@PathVariable long addressId) {
        return service.read(addressId);
    }

    @PutMapping("/update")
    public HomeAddress update(@RequestBody HomeAddress homeAddress) {
        return service.update(homeAddress);
    }

    @DeleteMapping("/delete/{addressId}")
    public boolean delete(@PathVariable long addressId){
        return service.delete(addressId);
    }

    @GetMapping("/getAll")
    public List<HomeAddress> getAll(){
        return service.getAll();
    }
}
