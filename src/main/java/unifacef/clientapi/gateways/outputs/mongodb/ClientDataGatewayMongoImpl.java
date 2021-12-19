package unifacef.clientapi.gateways.outputs.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import unifacef.clientapi.domains.Client;
import unifacef.clientapi.gateways.outputs.ClientDataGateway;
import unifacef.clientapi.gateways.outputs.mongodb.documents.ClientDocument;
import unifacef.clientapi.gateways.outputs.mongodb.repositories.ClientRepository;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientDataGatewayMongoImpl implements ClientDataGateway {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        if(Objects.isNull(client.getCreatedDate())){
            client.setCreatedDate(LocalDateTime.now());
        }
        return clientRepository.save(new ClientDocument(client)).toDomain();
    }

    @Override
    public Optional<Client> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Page<Client> findByPage(final Pageable pageable) {
        return clientRepository.findAll(pageable).map(ClientDocument::toDomain);
    }


}
