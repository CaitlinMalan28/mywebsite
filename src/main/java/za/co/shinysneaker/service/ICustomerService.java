package za.co.shinysneaker.service;

import za.co.shinysneaker.domain.Customer;
import java.util.List;

public interface ICustomerService extends IService<Customer, String>{

    List<Customer> getAll();

}
