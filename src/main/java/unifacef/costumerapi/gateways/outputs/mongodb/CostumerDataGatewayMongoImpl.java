package unifacef.costumerapi.gateways.outputs.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import unifacef.costumerapi.domains.Costumer;
import unifacef.costumerapi.gateways.outputs.CostumerDataGateway;
import unifacef.costumerapi.gateways.outputs.mongodb.documents.CostumerDocument;
import unifacef.costumerapi.gateways.outputs.mongodb.repositories.CostumerRepository;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CostumerDataGatewayMongoImpl implements CostumerDataGateway {

    private final CostumerRepository costumerRepository;

    @Override
    public Costumer save(final Costumer costumer) {
        if(Objects.isNull(costumer.getCreatedDate())){
            costumer.setCreatedDate(LocalDateTime.now());
        }
        return costumerRepository.save(new CostumerDocument(costumer)).toDomain();
    }

    @Override
    public Optional<Costumer> findById(final String id) {

        return costumerRepository.findById(id).map(CostumerDocument::toDomain);
    }

    @Override
    public Page<Costumer> findByPage(final Pageable pageable) {
        return costumerRepository.findAll(pageable).map(CostumerDocument::toDomain);
    }


}
