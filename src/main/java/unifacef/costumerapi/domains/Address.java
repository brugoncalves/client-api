package unifacef.costumerapi.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private Long id;
    private String streetName;
    private String district;
    private String city;
    private String zipCode;
}
