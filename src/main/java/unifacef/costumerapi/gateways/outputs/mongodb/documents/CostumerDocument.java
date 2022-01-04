package unifacef.costumerapi.gateways.outputs.mongodb.documents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import unifacef.costumerapi.domains.Address;
import unifacef.costumerapi.domains.Costumer;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("costumers")
public class CostumerDocument {

    @Id
    private String id;
    private String name;
    private String phone;
    private String driverLicense;
    private Boolean active;
    private Address address;
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifieldDate;


    public CostumerDocument(final Costumer costumer){
        this.id = costumer.getId();
        this.name = costumer.getName();
        this.phone = costumer.getPhone();
        this.driverLicense = costumer.getDriverLicense();
        this.active = costumer.getActive();
        this.address = costumer.getAddress();
        this.createdDate = costumer.getCreatedDate();
        this.lastModifieldDate = costumer.getLastModifiedDate();


    }

    public Costumer toDomain() {
        return Costumer.builder()
                .id(this.id)
                .name(this.name)
                .phone(this.phone)
                .driverLicense(this.driverLicense)
                .active(this.active)
                .address(this.address)
                .createdDate(this.createdDate)
                .lastModifiedDate(this.lastModifieldDate)
                .build();
    }
}
