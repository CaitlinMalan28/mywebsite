package za.co.shinysneaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.shinysneaker.domain.Customer;
import za.co.shinysneaker.domain.HomeAddress;

@Repository
public interface HomeAddressRepository extends JpaRepository<HomeAddress, Long> {
}
