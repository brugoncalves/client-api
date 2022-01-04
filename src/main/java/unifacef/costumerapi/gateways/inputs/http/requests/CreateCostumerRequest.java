package unifacef.costumerapi.gateways.inputs.http.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import unifacef.costumerapi.domains.Costumer;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateCostumerRequest extends CostumerRequest {

    private static final long serialVersionUID = 8743997776881612716L;

    @NotNull(message = "{required.field}")
    private String id;

    public Costumer toDomain() {
        return Costumer.builder()
                .id(this.id)
                .name(super.getName())
                .phone(super.getPhone())
                .driverLicense(super.getDriverLicense())
                .active(super.getActive())
                .address(super.getAddress())
                .build();
    }
}
