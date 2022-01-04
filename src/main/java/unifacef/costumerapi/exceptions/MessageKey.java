package unifacef.costumerapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

    COSTUMER_NOT_FOUND("costumer.not.found"),
    COSTUMER_ALREADY_EXISTS("costumer.already.exists");

    private String key;
}
