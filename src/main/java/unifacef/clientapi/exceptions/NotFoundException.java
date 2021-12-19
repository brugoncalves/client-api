package unifacef.clientapi.exceptions;

public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = -8769890558495873269L;

    public NotFoundException(final String message){
        super(message);
    }
}
