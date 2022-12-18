package zielinskin.h2example.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ChallengeController {

    @PostMapping("/calories")
    public Integer getHighestSubset(@RequestBody String input) {
        List<String> inputs = Arrays.stream(input.split("\n\n")).collect(Collectors.toList());
        Map<String, Integer> values = inputs.stream().collect(
                Collectors.toMap(Function.identity(),
                        (String s) ->
                                Arrays.stream(s.split("\n"))
                                        .map(Integer::parseInt)
                                        .reduce(0, Integer::sum)));

        return values.values().stream()
                .max(Integer::compare)
                .stream().limit(3)
                .reduce(0, Integer::sum);
    }

}
