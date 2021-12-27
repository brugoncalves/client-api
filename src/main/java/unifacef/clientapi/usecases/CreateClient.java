package unifacef.clientapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;
import unifacef.clientapi.configurations.ff4j.Features;
import unifacef.clientapi.domains.Client;
import static unifacef.clientapi.exceptions.MessageKey.CLIENT_ALREADY_EXISTS;
import unifacef.clientapi.gateways.outputs.ClientDataGateway;
import unifacef.clientapi.gateways.outputs.LocationGateway;
import unifacef.clientapi.utils.MessageUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateClient {

    private final ClientDataGateway clientDataGateway;
    private final MessageUtils messageUtils;
    private final LocationGateway locationGateway;
    private final FF4j ff4j;

    public Client execute(final Client client){
        log.info("Create client. Client id: {}", client.getId());
        if(clientDataGateway.findById(client.getId()).isPresent()){
            throw new IllegalArgumentException(
                    messageUtils.getMessage(CLIENT_ALREADY_EXISTS, client.getId()));
        }

        Client saved = clientDataGateway.save(client);
        if(ff4j.check(Features.SEND_TO_LOCATION.getKey())) {
            locationGateway.send(saved);
        }

        return saved;
    }
}
