package pro.belkin;

import lombok.*;

import java.io.*;

public interface FizzBuzz {
    String getReply(int number);

    String getFizzReply();

    int getFizzNumber();

    String getBuzzReply();

    int getBuzzNumber();

    String getFizzBuzzReply();

    boolean isFizzNumber(int number);

    boolean isBuzzNumber(int number);

    @AllArgsConstructor
    class NumberTooSmallException extends RuntimeException {
        @Serial
        private static final long serialVersionUID = 4451490028141848707L;

        public final int number;
    }
}
