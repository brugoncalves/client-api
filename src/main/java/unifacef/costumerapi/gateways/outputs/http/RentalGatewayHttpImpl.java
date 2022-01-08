package unifacef.costumerapi.gateways.outputs.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import unifacef.costumerapi.domains.Costumer;
import unifacef.costumerapi.gateways.outputs.RentalGateway;
import unifacef.costumerapi.gateways.outputs.http.resources.CostumerResource;

@Slf4j
@Component
@RequiredArgsConstructor
public class RentalGatewayHttpImpl implements RentalGateway {

    private final RentalFeignIntegration rentalFeignIntegration;

    @Override
    public void send(final Costumer costumer) {
        log.info("Sending costumer to Rental. Costumer id: {}",costumer.getId());
        CostumerResource costumerResource = new CostumerResource(costumer);
        rentalFeignIntegration.send(costumer.getId(), costumerResource);
    }
}
