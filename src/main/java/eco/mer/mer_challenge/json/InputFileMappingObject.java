package eco.mer.mer_challenge.json;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class InputFileMappingObject {

    private List<Integer> inputNumbers;

}
