package unifacef.clientapi.domains;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Client {

    private String id;
    private String name;
    private String phone;
    private String driverLicense;
    private Boolean active;
    private Address address;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
