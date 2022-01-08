package unifacef.costumerapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;
import unifacef.costumerapi.configurations.ff4j.Features;
import unifacef.costumerapi.domains.Costumer;
import unifacef.costumerapi.exceptions.NotFoundException;
import unifacef.costumerapi.gateways.outputs.CostumerDataGateway;
import unifacef.costumerapi.gateways.outputs.RentalGateway;
import unifacef.costumerapi.utils.MessageUtils;

import static unifacef.costumerapi.exceptions.MessageKey.COSTUMER_NOT_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateCostumer {

    private final CostumerDataGateway costumerDataGateway;
    private final RentalGateway rentalGateway;
    private final MessageUtils messageUtils;
    private final FF4j ff4j;

    public Costumer execute(final Costumer costumer) {
        log.info("Update costumer. Costumer id: {}", costumer.getId());
        Costumer oldCostumer = costumerDataGateway.findById(costumer.getId()).orElseThrow(() ->
                new NotFoundException(messageUtils.getMessage(COSTUMER_NOT_FOUND, costumer.getId())));
        costumer.setCreatedDate(oldCostumer.getCreatedDate());

        Costumer saved = costumerDataGateway.save(costumer);
        if (ff4j.check(Features.SEND_TO_RENTAL.getKey())) {
            rentalGateway.send(saved);
        }

        return saved;
    }
}
