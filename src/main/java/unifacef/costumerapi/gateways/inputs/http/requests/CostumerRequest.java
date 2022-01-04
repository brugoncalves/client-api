package unifacef.costumerapi.gateways.inputs.http.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import unifacef.costumerapi.domains.Address;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public abstract class CostumerRequest implements Serializable {

    private static final long serialVersionUID = 3475925051912891191L;

    @ApiModelProperty(position = 1)
    @NotNull(message = "{required.field}")
    private String name;

    @ApiModelProperty(position = 2)
    @NotNull(message = "{required.field}")
    private String phone;

    @ApiModelProperty(position = 3)
    private String driverLicense;

    @ApiModelProperty(position = 4)
    private Boolean active;

    @ApiModelProperty(position = 5)
    @NotNull(message = "{required.field}")
    private Address address;




}
