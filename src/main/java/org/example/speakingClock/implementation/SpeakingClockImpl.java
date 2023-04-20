package org.example.speakingClock.implementation;

import org.example.speakingClock.customException.InvalidTimeException;

public class SpeakingClockImpl implements ISpeakingClock {

    private static final String[] numberArray = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE","SIX", "SEVEN", "EIGHT", "NINE", "TEN",
            "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};

    private static final String[] numberArrayForTens = {"", "", "TWENTY", "THIRTY", "FORTY", "FIFTY"};

    @Override
    public String convertTime(String time) throws InvalidTimeException {
        validateInput(time);

        StringBuilder convertedTime = new StringBuilder("It's ");

        if(time.equals("00:00"))
        {
            return "It's MidNight";
        }
        else if (time.equals("12:00"))
        {
            return "It's Midday";
        }
        else {

            String[] splitTime = time.split(":");

            // first entry is hours, convert it first
            convertedTime.append(convertToString(Integer.parseInt(splitTime[0]))).append(" ");

            // second entry is minutes
            convertedTime.append(convertToString(Integer.parseInt(splitTime[1])));

        }
        return convertedTime.toString();
    }


    private void validateInput(String time) throws InvalidTimeException {
        // check if input is blank
        if(time == null || time.isEmpty())
        {
            throw new InvalidTimeException("Not a valid time");
        }

        // check input should contain symbol ':'

        if(!time.contains(":"))
        {
            throw new InvalidTimeException("Invalid time format");
        }

        // check if the input string length is not greater than 5 as maximum it can be 23:59
        if(time.length() > 5)
        {
            throw new InvalidTimeException("Input time should not be greater than 5 characters");
        }

        // TODO - check if the hours is not greater than 23 and not less than 0

        // TODO - check if minutes are not negative and not greater than 59

        //
    }

    private String convertToString(Integer input)
    {
        if(input < 20)
        {
            return numberArray[input];
        }
        return numberArrayForTens[input/10] + " " + (input % 10 > 0 ? convertToString(input % 10) : "");
    }
}
