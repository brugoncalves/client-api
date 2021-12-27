package unifacef.clientapi.gateways.inputs.http.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import unifacef.clientapi.domains.Client;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateClientRequest extends ClientRequest {

    private static final long serialVersionUID = 8743997776881612716L;

    @NotNull(message = "{required.field}")
    private String id;

    public Client toDomain() {
        return Client.builder()
                .id(this.id)
                .name(super.getName())
                .phone(super.getPhone())
                .driverLicense(super.getDriverLicense())
                .active(super.getActive())
                .address(super.getAddress())
                .build();
    }
}
