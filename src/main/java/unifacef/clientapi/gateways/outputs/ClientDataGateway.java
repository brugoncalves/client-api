package unifacef.clientapi.gateways.outputs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unifacef.clientapi.domains.Client;

import java.util.Optional;

public interface ClientDataGateway {

    Client save(Client client);

    Optional<Client> findById(String id);

    Page<Client> findByPage(Pageable pageable);
}
