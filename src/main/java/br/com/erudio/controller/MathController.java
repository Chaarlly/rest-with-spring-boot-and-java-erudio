package br.com.erudio.controller;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converts.NumberConverter;
import org.springframework.web.bind.annotation.*;

import static br.com.erudio.request.converts.NumberConverter.convertToDouble;

@RestController
@RequestMapping("math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    @PostMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return math.sum(convertToDouble(num1), convertToDouble(num2));
    }

    @PostMapping("/substract/{num1}/{num2}")
    public Double substract(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return math.substract(convertToDouble(num1), convertToDouble(num2));
    }

    @PostMapping("/multiply/{num1}/{num2}")
    public Double multiply(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return math.multiply(convertToDouble(num1),convertToDouble(num2));
    }

    @PostMapping("/division/{num1}/{num2}")
    public Double division(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return math.division(convertToDouble(num1),convertToDouble(num2));
    }

    @PostMapping("/average/{num1}/{num2}")
    public Double average(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return math.average(convertToDouble(num1),convertToDouble(num2));
    }

    @PostMapping("/sqrt/{num}")
    public Double sqrt(@PathVariable("num") String num) {
        if (!NumberConverter.isNumeric(num))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return math.sqrt(convertToDouble(num));
    }

}
