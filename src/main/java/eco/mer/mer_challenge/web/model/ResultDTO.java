package eco.mer.mer_challenge.web.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Builder
@Data
public class ResultDTO {
    private BigInteger uniqueNumber;
}
