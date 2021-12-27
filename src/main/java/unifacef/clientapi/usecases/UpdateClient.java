package unifacef.clientapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;
import unifacef.clientapi.configurations.ff4j.Features;
import unifacef.clientapi.domains.Client;
import unifacef.clientapi.exceptions.NotFoundException;
import unifacef.clientapi.gateways.outputs.ClientDataGateway;
import unifacef.clientapi.gateways.outputs.LocationGateway;
import unifacef.clientapi.utils.MessageUtils;

import static unifacef.clientapi.exceptions.MessageKey.CLIENT_NOT_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateClient {

    private final ClientDataGateway clientDataGateway;
    private final LocationGateway locationGateway;
    private final MessageUtils messageUtils;
    private final FF4j ff4j;

    public Client execute(final Client client) {
        log.info("Update client. Client id: {}", client.getId());
        Client oldClient = clientDataGateway.findById(client.getId()).orElseThrow(() ->
                new NotFoundException(messageUtils.getMessage(CLIENT_NOT_FOUND, client.getId())));
        client.setCreatedDate(oldClient.getCreatedDate());

        Client saved = clientDataGateway.save(client);
        if (ff4j.check(Features.SEND_TO_LOCATION.getKey())) {
            locationGateway.send(saved);
        }

        return saved;
    }
}
