package unifacef.clientapi.gateways.outputs.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unifacef.clientapi.gateways.outputs.http.resources.ClientResource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "location", url = "${integration.location.url}")
public interface LocationFeignIntegration {

    @PostMapping(path = "/apí/v1/clients/{id}", produces = APPLICATION_JSON_VALUE)
    void send(@PathVariable("id") final String id,
              final ClientResource clientResource);
}
