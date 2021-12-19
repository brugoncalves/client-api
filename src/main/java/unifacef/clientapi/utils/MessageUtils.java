package unifacef.clientapi.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import unifacef.clientapi.exceptions.MessageKey;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Component
@RequiredArgsConstructor
public class MessageUtils {

    private final MessageSource messageSource;

    public String getMessage(final MessageKey messageKey, final Object... param) {
        return messageSource.getMessage(messageKey.getKey(), param, getLocale());
    }
}
