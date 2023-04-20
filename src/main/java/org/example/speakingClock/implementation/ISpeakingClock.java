package org.example.speakingClock.implementation;

import org.example.speakingClock.customException.InvalidTimeException;

public interface ISpeakingClock {
    /**
     * The method will convert the given time into words.
     * Like 9:30 will be converted to "Nine Thirty"
     *
     * @param time
     * @return
     */
    String convertTime(String time) throws InvalidTimeException;

}
