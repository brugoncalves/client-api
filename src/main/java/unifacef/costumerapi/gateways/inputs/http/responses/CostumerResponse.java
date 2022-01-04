package unifacef.costumerapi.gateways.inputs.http.responses;

import io.swagger.annotations.ApiModelProperty;
import unifacef.costumerapi.domains.Address;
import unifacef.costumerapi.domains.Costumer;

import java.io.Serializable;

public class CostumerResponse implements Serializable {

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



    public CostumerResponse(final Costumer costumer){
        this.id = costumer.getId();
        this.name = costumer.getName();
        this.phone = costumer.getPhone();
        this.driverLicense = costumer.getDriverLicense();
        this.active = costumer.getActive();
        this.address = costumer.getAddress();
    }
}
