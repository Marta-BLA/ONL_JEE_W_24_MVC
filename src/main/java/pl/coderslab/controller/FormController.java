package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/first")
public class FormController {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processDate(@RequestParam("paramName") String paramName, @RequestParam("paramDate") String paramDate) {
        LocalDate formattedDate = LocalDate.parse(paramDate, DATE_TIME_FORMATTER);
        return "ParamName: " + paramName + ". ParamDate: " + formattedDate;
    }

}
