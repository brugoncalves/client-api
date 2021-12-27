package unifacef.clientapi.gateways.inputs.http.requests;

import unifacef.clientapi.domains.Client;

public class UpdateClientRequest extends ClientRequest {

    private static final long serialVersionUID = 8743997776881612716L;

    public Client toDomain(final String id) {
        return Client.builder()
                .id(id)
                .name(super.getName())
                .phone(super.getPhone())
                .driverLicense(super.getDriverLicense())
                .active(super.getActive())
                .address(super.getAddress())
                .build();
    }
}
