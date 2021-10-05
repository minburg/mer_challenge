package eco.mer.mer_challenge.web.controller;

import eco.mer.mer_challenge.service.UniqueNumberService;
import eco.mer.mer_challenge.web.model.ResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MERRestControllerImpl implements MERRestController{

    private final UniqueNumberService uniqueNumberService;

    @Override
    public ResponseEntity<ResultDTO> getUniqueNumber(int parts) {
        return ResponseEntity.ok(uniqueNumberService.getUniqueNumber(parts));
    }
}
