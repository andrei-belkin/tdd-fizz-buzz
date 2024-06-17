package pro.belkin;

import lombok.*;

import java.io.*;

@Getter
@AllArgsConstructor
public abstract class CustomFizzBuzz implements FizzBuzz {
    public final String fizzReply;
    public final int fizzNumber;

    public final String buzzReply;
    public final int buzzNumber;

    @Override
    public String getFizzBuzzReply() {
        return fizzReply + buzzReply;
    }

    @Override
    public String getReply(final int number) {
        if (number <= 0)
            throw new NumberTooSmallException(number);
        if (number % (fizzNumber * buzzNumber) == 0)
            return getFizzBuzzReply();
        if (number % fizzNumber == 0)
            return fizzReply;
        if (number % buzzNumber == 0)
            return buzzReply;
        return String.valueOf(number);
    }

    @Override
    public boolean isFizzNumber(int number) {
        return number % fizzNumber == 0;
    }

    @Override
    public boolean isBuzzNumber(int number) {
        return number % buzzNumber == 0;
    }
}
