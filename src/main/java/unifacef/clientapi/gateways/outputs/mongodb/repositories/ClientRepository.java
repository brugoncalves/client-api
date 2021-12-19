package unifacef.clientapi.gateways.outputs.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import unifacef.clientapi.gateways.outputs.mongodb.documents.ClientDocument;

public interface ClientRepository extends MongoRepository<ClientDocument, String> {
}
