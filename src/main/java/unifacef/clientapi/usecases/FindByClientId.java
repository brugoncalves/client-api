package unifacef.clientapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import unifacef.clientapi.domains.Client;
import unifacef.clientapi.exceptions.NotFoundException;
import unifacef.clientapi.gateways.outputs.ClientDataGateway;

import unifacef.clientapi.utils.MessageUtils;


import static unifacef.clientapi.exceptions.MessageKey.CLIENT_NOT_FOUND;

@Component
@Slf4j
@RequiredArgsConstructor
public class FindByClientId {

    private final ClientDataGateway clientDataGateway;
    private final MessageUtils messageUtils;

    public Client execute(final String id){
        log.info("Find id. Client code : {}", id);
        return clientDataGateway.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtils.getMessage(CLIENT_NOT_FOUND, id)));
    }
}
