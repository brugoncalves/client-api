package unifacef.clientapi.gateways.outputs.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import unifacef.clientapi.domains.Client;
import unifacef.clientapi.gateways.outputs.LocationGateway;
import unifacef.clientapi.gateways.outputs.http.resources.ClientResource;

@Slf4j
@Component
@RequiredArgsConstructor
public class LocationGatewayHttpImpl implements LocationGateway {

    private final LocationFeignIntegration locationFeignIntegration;

    @Override
    public void send(final Client client) {
        log.info("Sending client to Location. Client id: {}", client.getId());
        ClientResource clientResource = new ClientResource(client);
        locationFeignIntegration.send(client.getId(), clientResource);
    }
}
