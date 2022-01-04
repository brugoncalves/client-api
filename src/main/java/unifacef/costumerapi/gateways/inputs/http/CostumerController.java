package unifacef.costumerapi.gateways.inputs.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import unifacef.costumerapi.domains.Costumer;
import unifacef.costumerapi.gateways.inputs.http.requests.CreateCostumerRequest;
import unifacef.costumerapi.gateways.inputs.http.requests.UpdateCostumerRequest;
import unifacef.costumerapi.gateways.inputs.http.responses.CostumerResponse;
import unifacef.costumerapi.gateways.inputs.http.responses.ListResponse;
import unifacef.costumerapi.usecases.CreateCostumer;
import unifacef.costumerapi.usecases.FindByCostumerId;
import unifacef.costumerapi.usecases.FindCostumers;
import unifacef.costumerapi.usecases.UpdateCostumer;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/costumers")
public class CostumerController {


    private final CreateCostumer createClient;
    private final UpdateCostumer updateCostumer;
    private final FindByCostumerId findByCostumerId;
    private final FindCostumers findCostumers;

    @GetMapping
    public ListResponse<CostumerResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                     @RequestParam(defaultValue = "20") final Integer size){
        Page<CostumerResponse> clientPage = findCostumers.execute(PageRequest.of(page, size)).map(CostumerResponse::new);
        return new ListResponse<>(clientPage);
    }

    @PostMapping
    public CostumerResponse create(@RequestBody @Validated final CreateCostumerRequest request) {
        Costumer costumer = createClient.execute(request.toDomain());
        return new CostumerResponse(costumer);
    }

    @PutMapping(path = "/{id}")
    public CostumerResponse update(@PathVariable final String id,
                                   @RequestBody @Validated final UpdateCostumerRequest request) {
        Costumer costumer = updateCostumer.execute(request.toDomain(id));
        return new CostumerResponse(costumer);
    }

    @GetMapping(path = "/{id}")
    public CostumerResponse find(@PathVariable final String id) {
        Costumer costumer = findByCostumerId.execute(id);
        return new CostumerResponse(costumer);
    }
}
