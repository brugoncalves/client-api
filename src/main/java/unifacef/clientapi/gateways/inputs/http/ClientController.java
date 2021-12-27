package unifacef.clientapi.gateways.inputs.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import unifacef.clientapi.domains.Client;
import unifacef.clientapi.gateways.inputs.http.requests.CreateClientRequest;
import unifacef.clientapi.gateways.inputs.http.requests.UpdateClientRequest;
import unifacef.clientapi.gateways.inputs.http.responses.ClientResponse;
import unifacef.clientapi.gateways.inputs.http.responses.ListResponse;
import unifacef.clientapi.usecases.CreateClient;
import unifacef.clientapi.usecases.FindByClientId;
import unifacef.clientapi.usecases.FindClients;
import unifacef.clientapi.usecases.UpdateClient;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/clients")
public class ClientController {


    private final CreateClient createClient;
    private final UpdateClient updateClient;
    private final FindByClientId findByClientId;
    private final FindClients findClients;

    @GetMapping
    public ListResponse<ClientResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                   @RequestParam(defaultValue = "20") final Integer size){
        Page<ClientResponse> clientPage = findClients.execute(PageRequest.of(page, size)).map(ClientResponse::new);
        return new ListResponse<>(clientPage);
    }

    @PostMapping
    public ClientResponse create(@RequestBody @Validated final CreateClientRequest request) {
        Client client = createClient.execute(request.toDomain());
        return new ClientResponse(client);
    }

    @PutMapping(path = "/{id}")
    public ClientResponse update(@PathVariable final String id,
                                 @RequestBody @Validated final UpdateClientRequest request) {
        Client client = updateClient.execute(request.toDomain(id));
        return new ClientResponse(client);
    }

    @GetMapping(path = "/{id}")
    public ClientResponse find(@PathVariable final String id) {
        Client client = findByClientId.execute(id);
        return new ClientResponse(client);
    }
}
