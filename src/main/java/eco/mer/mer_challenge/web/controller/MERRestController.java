package eco.mer.mer_challenge.web.controller;

import eco.mer.mer_challenge.web.model.ResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api-v1/")
public interface MERRestController {

    @GetMapping("generate-unique-number")
    public ResponseEntity<ResultDTO> getUniqueNumber(@RequestParam int parts);

}
