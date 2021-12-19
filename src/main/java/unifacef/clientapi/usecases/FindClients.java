package unifacef.clientapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import unifacef.clientapi.domains.Client;
import unifacef.clientapi.gateways.outputs.ClientDataGateway;



@Slf4j
@Component
@RequiredArgsConstructor
public class FindClients {

    private final ClientDataGateway clientDataGateway;

    public Page<Client> execute(final Pageable pageable) {
        log.info("Find clients. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return clientDataGateway.findByPage(pageable);
    }
}
