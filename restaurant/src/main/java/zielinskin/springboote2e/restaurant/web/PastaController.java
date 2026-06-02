package zielinskin.springboote2e.restaurant.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.common.web.AbstractCrudController;
import zielinskin.springboote2e.restaurant.api.Pasta;
import zielinskin.springboote2e.restaurant.api.PastaService;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pastas")
class PastaController extends AbstractCrudController<Pasta, Integer, PastaService> {
    public PastaController(PastaService service) {
        super(service);
    }


    @PostMapping("/addSomeNumbers")
    public Double kyrosMethodThatIsReallyCool(@RequestBody List<Double> numbers) {
        Double retVal = 0d;
        for(Double val : numbers) {
            retVal += val;
        }
        return retVal;
    }

    @PostMapping("/multiplySomeNumbers")
    public Double doubleMultiply(@RequestBody List<Double> numbers) {
        return operateOnMyDoubles(numbers, this::multiply);
    }

    @PostMapping("/sumSomeNumbers")
    public Double doubleSum(@RequestBody List<Double> numbers) {
        return operateOnMyDoubles(numbers, Double::sum);
    }

    @PostMapping("/addSomeStrings")
    public String addStrings(@RequestBody List<String> strings) {
        return String.join(", ", strings);
    }

    @GetMapping("/concatStringsWithOtherValue/{first}/{second}")
    public String addStrings(@PathVariable("first") String first, @PathVariable("second") Integer second) {
        return String.format("%s %d were concatenated", first, second);
    }


    private Double multiply(Double o1, Double o2) {
        return o1 * o2;
    }

    private Double operateOnMyDoubles(List<Double> numbers, BinaryOperator<Double> operator) {
        return numbers.stream()
                .reduce(operator)
                .orElse(0d);
    }
}