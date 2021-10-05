package eco.mer.mer_challenge.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import eco.mer.mer_challenge.json.InputFileMappingObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;

@Service
public class FileReaderService {

    @Value("classpath:mer_unc_input.json")
    Resource resourceFile;

    public InputFileMappingObject readFromResourceFile(){
        try {
            File json = resourceFile.getFile();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, InputFileMappingObject.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server could not read json file");
        }
    }

}
