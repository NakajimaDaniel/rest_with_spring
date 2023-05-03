package com.example.rest_with_spring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/sum/{numberOne}/{numberTwo}")
  public Double sum(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) throws Exception {

    if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

  @GetMapping("sub/{numberOne}/{numberTwo}")
  public Double sub(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) {
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return convertToDouble(numberOne) - convertToDouble(numberTwo);
  }

  @GetMapping("mul/{numberOne}/{numberTwo}")
  public Double mul(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) {
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return convertToDouble(numberOne) * convertToDouble(numberTwo);
  }

  @GetMapping("div/{numberOne}/{numberTwo}")
  public Double div(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) {
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return convertToDouble(numberOne) / convertToDouble(numberTwo);
  }

  @GetMapping("med/{numberOne}/{numberTwo}")
  public Double med(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) {
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
  }

  @GetMapping("sqrt/{numberOne}/{numberTwo}")
  public Double mod(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) {
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }
    return Math.sqrt(convertToDouble(numberOne) * convertToDouble(numberTwo));
  }

  private Double convertToDouble(String strNumber) {
    if (strNumber == null)
      return 0D;
    String number = strNumber.replaceAll(",", ".");
    if (isNumeric(number))
      return Double.parseDouble(number);
    return 0D;
  }

  private boolean isNumeric(String strNumber) {
    if (strNumber == null)
      return false;
    String number = strNumber.replaceAll(",", ".");
    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }
}
