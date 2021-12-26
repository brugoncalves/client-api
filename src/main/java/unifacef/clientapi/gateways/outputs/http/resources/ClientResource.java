package unifacef.clientapi.gateways.outputs.http.resources;

import lombok.Data;
import unifacef.clientapi.domains.Address;
import unifacef.clientapi.domains.Client;

import java.time.LocalDateTime;

@Data
public class ClientResource {


    private String name;
    private String phone;
    private String driverLicense;
    private Boolean active;
    private Address address;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public ClientResource(final Client client) {
       this.name = client.getName();
       this.phone = client.getPhone();
       this.driverLicense = client.getDriverLicense();
       this.active = client.getActive();
       this.address = client.getAddress();
       this.createdDate = client.getCreatedDate();
       this.lastModifiedDate = client.getLastModifiedDate();
    }

}
