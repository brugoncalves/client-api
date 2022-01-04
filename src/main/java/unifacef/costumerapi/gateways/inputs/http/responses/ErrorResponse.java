package unifacef.costumerapi.gateways.inputs.http.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class ErrorResponse implements Serializable {
    private static final long servialVersionUID = -3941434646549309532L;

    private List<String> errors = new ArrayList<>();
}
