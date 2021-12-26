package unifacef.clientapi.gateways.inputs.http.handlers;

import lombok.extern.slf4j.Slf4j;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import unifacef.clientapi.exceptions.NotFoundException;
import unifacef.clientapi.gateways.inputs.http.responses.ErrorResponse;

import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @ExceptionHandler(NotFoundException.class)
    public HttpEntity<ErrorResponse> handleNotFoundException(final NotFoundException ex){
        log.error(ex.getMessage(), ex);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createMessage(ex), responseHeaders, HttpStatus.NOT_FOUND);
    }

    private ErrorResponse createMessage(final Throwable ex){
        ErrorResponse message = null;
        if(isNotBlank(ex.getMessage())) {
            message = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        }
        return message;
    }
}
