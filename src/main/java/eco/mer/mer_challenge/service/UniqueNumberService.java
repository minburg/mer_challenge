package eco.mer.mer_challenge.service;

import eco.mer.mer_challenge.json.InputFileMappingObject;
import eco.mer.mer_challenge.web.model.ResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class UniqueNumberService {

    private final FileReaderService fileReaderService;

    private static final RandomGenerator randomGenerator = RandomGeneratorFactory.getDefault().create(42);

    public ResultDTO getUniqueNumber(int parts) {

        if(parts < 1 || parts > 10){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RequestParam parts should be from 1 to 10");
        }

        InputFileMappingObject inputFileMappingObject = fileReaderService.readFromResourceFile();

        List<Integer> intList = IntStream.range(0, parts).map(generatedInt -> {
            int nextInt = randomGenerator.nextInt();
            nextInt = nextInt % inputFileMappingObject.getInputNumbers().size();
            return nextInt < 0 ? nextInt * -1 : nextInt;
        }).boxed().collect(Collectors.toList());
        List<Integer> randomlyPickedNumbers = intList.stream().map(intConsumer -> inputFileMappingObject.getInputNumbers().get(intConsumer)).collect(Collectors.toList());

        return ResultDTO.builder().uniqueNumber(randomlyPickedNumbers.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply)).build();
    }
}
