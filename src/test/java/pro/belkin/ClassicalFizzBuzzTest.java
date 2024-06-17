package pro.belkin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.*;

import java.security.*;
import java.util.random.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClassicalFizzBuzzTest {
    private static final RandomGenerator RANDOM = new SecureRandom();

    private FizzBuzz fizzBuzz;

    private String fizzReply;
    private int fizzNumber;

    private String buzzReply;
    private int buzzNumber;

    private String fizzBuzzReply;

    @BeforeEach
    public void setUp() {
        fizzBuzz = new ClassicalFizzBuzz();

        fizzReply = fizzBuzz.getFizzReply();
        fizzNumber = fizzBuzz.getFizzNumber();

        buzzReply = fizzBuzz.getBuzzReply();
        buzzNumber = fizzBuzz.getBuzzNumber();

        fizzBuzzReply = fizzBuzz.getFizzBuzzReply();
    }

    @Test
    public void givenNonFizzBuzzNumber_willReturnNumber() {
        assertEquals("1", fizzBuzz.getReply(1));
        assertEquals("98", fizzBuzz.getReply(98));
    }

    @Test
    public void givenNumberLessOrEqualToZero_willThrow() {
        final int randomNegativeInt = RANDOM.nextInt(Integer.MIN_VALUE, 0);
        final Executable negativeReplyGetter = () -> fizzBuzz.getReply(randomNegativeInt);
        assertThrows(CustomFizzBuzz.NumberTooSmallException.class, negativeReplyGetter);

        final Executable zeroReplyGetter = () -> fizzBuzz.getReply(0);
        assertThrows(CustomFizzBuzz.NumberTooSmallException.class, zeroReplyGetter);
    }

    @Test
    public void givenFizzNumber_willReturnFizz() {
        final int randomFizzNumber = generateFizzNumber();
        assertEquals(fizzReply, fizzBuzz.getReply(randomFizzNumber));
    }

    private int generateFizzNumber() {
        int generated = RANDOM.nextInt(100000000) * fizzNumber;
        while (fizzBuzz.isBuzzNumber(generated))
            generated = generateFizzNumber();
        return generated;
    }

    @Test
    public void givenBuzzNumber_willReturnBuzz() {
        final int randomBuzzNumber = generateBuzzNumber();
        assertEquals(buzzReply, fizzBuzz.getReply(randomBuzzNumber));
    }

    private int generateBuzzNumber() {
        int generated = RANDOM.nextInt(100000000) * buzzNumber;
        while (fizzBuzz.isFizzNumber(generated))
            generated = generateBuzzNumber();
        return generated;
    }

    @Test
    public void givenFizzBuzzNumber_willReturnFizzBuzz() {
        for (int i = 1; i < 1000; i++) {
            final int number = fizzNumber * buzzNumber * RANDOM.nextInt(100000000);
            final String reply = fizzBuzz.getReply(number);
            assertEquals(fizzBuzzReply, reply);
        }
    }
}
