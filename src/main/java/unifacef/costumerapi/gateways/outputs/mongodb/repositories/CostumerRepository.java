package unifacef.costumerapi.gateways.outputs.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import unifacef.costumerapi.gateways.outputs.mongodb.documents.CostumerDocument;

public interface CostumerRepository extends MongoRepository<CostumerDocument, String> {
}
