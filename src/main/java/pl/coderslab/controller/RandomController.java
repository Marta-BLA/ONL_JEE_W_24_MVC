package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;

@Controller
public class RandomController {

    private Random random = new Random();

    @GetMapping(value = "/showRandom", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRandom() {
        int randomNumber = random.nextInt(100) + 1;
        return "Wylosowano liczbę: " + randomNumber;
    }

    @GetMapping(value = "/random/{min}/{max}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRandomMinMax(@PathVariable int min, @PathVariable int max) {
        int randomNumber = random.nextInt(max - min + 1) + min;
        return "Użytkownik podał wartość min: " + min + " i max: " + max + ". Wylosowano liczbę: " + randomNumber;
    }

    @GetMapping(value = "/random/{max}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRandomMax(@PathVariable int max) {
        int randomNumber = random.nextInt(max) + 1;
        return "Użytkownik podał wartość: " + max + ". Wylosowano liczbę: " + randomNumber;
    }

}
