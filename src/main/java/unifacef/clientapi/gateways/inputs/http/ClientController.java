package unifacef.clientapi.gateways.inputs.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unifacef.clientapi.gateways.inputs.http.responses.ClientResponse;
import unifacef.clientapi.gateways.inputs.http.responses.ListResponse;
import unifacef.clientapi.usecases.FindClients;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/clients")
public class ClientController {

    private final FindClients findClients;

    public ListResponse<ClientResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                   @RequestParam(defaultValue = "20") final Integer size){
        Page<ClientResponse> clientPage = findClients.execute(PageRequest.of(page, size)).map(ClientResponse::new);
        return new ListResponse<>(clientPage);
    }
}
