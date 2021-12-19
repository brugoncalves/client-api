package unifacef.clientapi.gateways.inputs.http.responses;

import io.swagger.annotations.ApiModelProperty;
import unifacef.clientapi.domains.Address;
import unifacef.clientapi.domains.Client;

import java.io.Serializable;

public class ClientResponse implements Serializable {

    @ApiModelProperty(position = 0)
    private String id;

    @ApiModelProperty(position = 1)
    private String name;

    @ApiModelProperty(position = 2)
    private String phone;

    @ApiModelProperty(position = 3)
    private String driverLicense;

    @ApiModelProperty(position = 4)
    private Boolean active;

    @ApiModelProperty(position = 5)
    private Address address;



    public ClientResponse(final Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.phone = client.getPhone();
        this.driverLicense = client.getDriverLicense();
        this.active = client.getActive();
        this.address = client.getAddress();
    }
}
