package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;rc/


@Controller
public class FreeTimeController {

    private static final Logger logger = LoggerFactory.getLogger(FreeTimeController.class);

    private static final LocalTime START_WORK = LocalTime.of(9,0);
    private static final LocalTime END_WORK = LocalTime.of(17,0);

    @GetMapping("/checkTime")
    @ResponseBody
    public String checkTime() {
        logger.debug("Started method to check time");
        LocalDateTime localDateTime = LocalDateTime.now();
        logger.debug("Checking free time for {}", localDateTime);
        if (DayOfWeek.SATURDAY.equals(localDateTime.getDayOfWeek())
                || DayOfWeek.SUNDAY.equals(localDateTime.getDayOfWeek())) {
            logger.debug("Given day is day off: {}", localDateTime.getDayOfWeek());
            return "Wolne";
        } else if (localDateTime.toLocalTime().isAfter(START_WORK) && localDateTime.toLocalTime().isBefore(END_WORK)) {
            logger.debug("working hours, do not disturb: {}", localDateTime.toLocalTime());
            return "Pracuje, nie dzwon";
        } else {
            logger.debug("working day but not working hours, {}", localDateTime.toLocalTime());
            return "Po pracy";
        }
    }

}
