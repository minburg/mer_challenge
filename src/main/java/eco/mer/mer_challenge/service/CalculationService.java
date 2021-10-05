package eco.mer.mer_challenge.service;

import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculationService {


    private List<Integer> findResults(List<Integer> input, int target, int count) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        if(count > input.size()){
            throw new RuntimeException("Bad input for combination algorithm");
        }

        List<List<Integer>> combinations = Generator.combination(input)
                .simple(count)
                .stream()
                .collect(Collectors.toList());

        return combinations.stream().filter((a) -> !a.isEmpty() && a.stream().reduce(0, Integer::sum) == target)
                .findFirst().orElseGet(ArrayList::new);
    }


    public BigInteger findNNumbersSumEqualsTarget(List<Integer> input, int target, int count) {
        List<Integer> result = findResults(input, target, count);
        if(result == null || result.isEmpty()){
            return BigInteger.ZERO;
        }

        List<BigInteger> bigIntegers = result.stream().map(BigInteger::valueOf).collect(Collectors.toList());

        return bigIntegers.stream().reduce(BigInteger::multiply).orElseThrow(RuntimeException::new);
    }
}
