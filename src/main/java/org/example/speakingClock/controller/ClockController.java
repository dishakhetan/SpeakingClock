package org.example.speakingClock.controller;

import org.example.speakingClock.customException.InvalidTimeException;
import org.example.speakingClock.implementation.ISpeakingClock;

@Controller
public class ClockController {

    @Autowired
    private ISpeakingClock speakingClock;

    @RequestMapping("/getTime")
    @ResponseBody
    // Method
    public String getTime(String time) throws InvalidTimeException {
        return speakingClock.convertTime(time);
    }

}
