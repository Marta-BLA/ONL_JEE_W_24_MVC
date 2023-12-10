package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/helloView")
    public String helloView(Model model) {
        LocalTime currentTime = LocalTime.of(1, 0); //LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(8, 0)) &&
                currentTime.isBefore(LocalTime.of(20, 0))) {
            model.addAttribute("color", "black");
            model.addAttribute("backgroundColor", "white");
        } else {
            model.addAttribute("color", "white");
            model.addAttribute("backgroundColor", "black");
        }
        return "home";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        logger.debug("My first log");
        return "Hello world";
    }

}
