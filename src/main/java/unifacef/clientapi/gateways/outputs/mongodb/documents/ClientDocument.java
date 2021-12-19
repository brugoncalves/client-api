package unifacef.clientapi.gateways.outputs.mongodb.documents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import unifacef.clientapi.domains.Address;
import unifacef.clientapi.domains.Client;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("clients")
public class ClientDocument {

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


    public ClientDocument(final Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.phone = client.getPhone();
        this.driverLicense = client.getDriverLicense();
        this.active = client.getActive();
        this.address = client.getAddress();
        this.createdDate = client.getCreatedDate();
        this.lastModifieldDate = client.getLastModifiedDate();


    }

    public Client toDomain() {
        return Client.builder()
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
