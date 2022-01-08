package unifacef.costumerapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;
import unifacef.costumerapi.configurations.ff4j.Features;
import unifacef.costumerapi.domains.Costumer;

import static unifacef.costumerapi.exceptions.MessageKey.COSTUMER_ALREADY_EXISTS;

import unifacef.costumerapi.gateways.outputs.CostumerDataGateway;
import unifacef.costumerapi.gateways.outputs.RentalGateway;
import unifacef.costumerapi.utils.MessageUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateCostumer {

    private final CostumerDataGateway costumerDataGateway;
    private final MessageUtils messageUtils;
    private final RentalGateway rentalGateway;
    private final FF4j ff4j;

    public Costumer execute(final Costumer costumer){
        log.info("Create costumer. Costumer id: {}",costumer.getId());
        if(costumerDataGateway.findById(costumer.getId()).isPresent()){
            throw new IllegalArgumentException(
                    messageUtils.getMessage(COSTUMER_ALREADY_EXISTS, costumer.getId()));
        }

        Costumer saved = costumerDataGateway.save(costumer);
        if(ff4j.check(Features.SEND_TO_RENTAL.getKey())) {
            rentalGateway.send(saved);
        }

        return saved;
    }
}
