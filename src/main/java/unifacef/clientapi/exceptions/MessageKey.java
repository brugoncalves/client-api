package unifacef.clientapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

    CLIENT_NOT_FOUND("client.not.found"),
    CLIENT_ALREADY_EXISTS("client.already.exists");

    private String key;
}
