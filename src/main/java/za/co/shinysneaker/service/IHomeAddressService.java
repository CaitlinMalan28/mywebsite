package za.co.shinysneaker.service;

import za.co.shinysneaker.domain.HomeAddress;
import java.util.List;

public interface IHomeAddressService extends IService<HomeAddress, Long>{

    List<HomeAddress> getAll();

}
