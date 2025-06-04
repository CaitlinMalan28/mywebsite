package za.co.shinysneaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.domain.HomeAddress;
import za.co.shinysneaker.repository.HomeAddressRepository;

import java.util.List;

@Service
public class HomeAddressService implements IHomeAddressService {

    private HomeAddressRepository repository;

    @Autowired  HomeAddressService(HomeAddressRepository repository){
        this.repository = repository;
    }

    @Override
    public HomeAddress create(HomeAddress homeAddress) {
        return this.repository.save(homeAddress);    }

    @Override
    public HomeAddress read(Long longAddressID) {
        return this.repository.findById(longAddressID).orElse(null);
    }

    @Override
    public HomeAddress update(HomeAddress homeAddress) {
        return this.repository.save(homeAddress);
    }

    @Override
    public boolean delete(Long longAddressID) {
        repository.deleteById(longAddressID);
        return true;
    }

    @Override
    public List<HomeAddress> getAll() {
        return this.repository.findAll();
    }

}
