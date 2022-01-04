package unifacef.costumerapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import unifacef.costumerapi.domains.Costumer;
import unifacef.costumerapi.gateways.outputs.CostumerDataGateway;



@Slf4j
@Component
@RequiredArgsConstructor
public class FindCostumers {

    private final CostumerDataGateway costumerDataGateway;

    public Page<Costumer> execute(final Pageable pageable) {
        log.info("Find clients. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return costumerDataGateway.findByPage(pageable);
    }
}
