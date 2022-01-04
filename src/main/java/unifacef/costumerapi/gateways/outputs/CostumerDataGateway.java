package unifacef.costumerapi.gateways.outputs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unifacef.costumerapi.domains.Costumer;

import java.util.Optional;

public interface CostumerDataGateway {

    Costumer save(Costumer costumer);

    Optional<Costumer> findById(String id);

    Page<Costumer> findByPage(Pageable pageable);
}
