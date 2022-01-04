package unifacef.clientapi.configurations.ff4j;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Features {

    SEND_TO_LOCATION(
            "send-to-rental",
            "features",
            "Envia o cliente cadastrado para a Rental",
            true);

    private final String key;
    private final String groupName;
    private final String description;
    private final boolean defaultValue;
}
