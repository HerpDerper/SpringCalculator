package com.example.CalculatorSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String calculatorForm(Model model) {
        model.addAttribute("calculator", new CalculatorModel());
        return "calculator";
    }

    @GetMapping("/calculatorGet")
    public String calculateFormResultGet(@ModelAttribute("calculator") CalculatorModel calculatorModel) {
        double a = calculatorModel.getNumber1();
        double b = calculatorModel.getNumber2();
        double result;
        switch (calculatorModel.getOperator()) {
            case "plus":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
            case "multiple":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculatorModel.getOperator());
        }
        calculatorModel.setResult(result);
        return "calculator";
    }

    @PostMapping("/calculatorPost")
    public String calculateFormResultPost(@ModelAttribute CalculatorModel calculatorModel, Model model) {
        double a = calculatorModel.getNumber1();
        double b = calculatorModel.getNumber2();
        double result;
        switch (calculatorModel.getOperator()) {
            case "plus":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
            case "multiple":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculatorModel.getOperator());
        }
        calculatorModel.setResult(result);
        model.addAttribute("calculator", calculatorModel);
        return "calculator";
    }
}