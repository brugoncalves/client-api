package unifacef.costumerapi.gateways.outputs.http.resources;

import lombok.Data;
import unifacef.costumerapi.domains.Address;
import unifacef.costumerapi.domains.Costumer;

import java.time.LocalDateTime;

@Data
public class CostumerResource {


    private String name;
    private String phone;
    private String driverLicense;
    private Boolean active;
    private Address address;


    public CostumerResource(final Costumer costumer) {
       this.name = costumer.getName();
       this.phone = costumer.getPhone();
       this.driverLicense = costumer.getDriverLicense();
       this.active = costumer.getActive();
       this.address = costumer.getAddress();
    }

}
