package pro.belkin;

public class Demo {
    private static FizzBuzz fizzBuzz;

    public static void main(String[] args) {
        fizzBuzz = new ClassicalFizzBuzz();

        for (int i = -100; i < 100; i++) {
            runFizzBuzz(i);
        }
    }

    private static void runFizzBuzz(final int number) {
        try {
            System.out.println(fizzBuzz.getReply(number));
        } catch (FizzBuzz.NumberTooSmallException exception) {
            System.out.println(number + " is too small");
        }
    }
}
