package unifacef.costumerapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import unifacef.costumerapi.domains.Costumer;
import unifacef.costumerapi.exceptions.NotFoundException;
import unifacef.costumerapi.gateways.outputs.CostumerDataGateway;

import unifacef.costumerapi.utils.MessageUtils;

import static unifacef.costumerapi.exceptions.MessageKey.COSTUMER_NOT_FOUND;


@Component
@Slf4j
@RequiredArgsConstructor
public class FindByCostumerId {

    private final CostumerDataGateway costumerDataGateway;
    private final MessageUtils messageUtils;

    public Costumer execute(final String id){
        log.info("Find id. Client code : {}", id);
        return costumerDataGateway.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtils.getMessage(COSTUMER_NOT_FOUND, id)));
    }
}
