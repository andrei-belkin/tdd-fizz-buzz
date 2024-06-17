package pro.belkin;

import lombok.*;

import java.util.*;
import java.util.function.*;

@Getter
@AllArgsConstructor
public abstract class CustomFizzBuzz implements FizzBuzz {
    public final String fizzReply;
    public final int fizzNumber;

    public final String buzzReply;
    public final int buzzNumber;

    @Override
    public List<Map.Entry<Predicate<Integer>, String>> getRules() {
        final List<Map.Entry<Predicate<Integer>, String>> rules = new ArrayList<>();
        rules.add(Map.entry((number) -> number % (fizzNumber * buzzNumber) == 0, getFizzBuzzReply()));
        rules.add(Map.entry((number) -> number % fizzNumber == 0, fizzReply));
        rules.add(Map.entry((number) -> number % buzzNumber == 0, buzzReply));
        return rules;
    }

    @Override
    public String getFizzBuzzReply() {
        return fizzReply + buzzReply;
    }

    @Override
    public String getReply(final int number) {
        if (number <= 0)
            throw new NumberTooSmallException(number);

        final List<Map.Entry<Predicate<Integer>, String>> rules = getRules();

        final Optional<Map.Entry<Predicate<Integer>, String>> matchingRule = rules.stream()
            .filter(rule -> rule.getKey().test(number))
            .limit(1)
            .findFirst();
        return matchingRule.map(Map.Entry::getValue)
            .orElse(String.valueOf(number));
    }

    @Override
    public boolean isFizzNumber(final int number) {
        return number % fizzNumber == 0;
    }

    @Override
    public boolean isBuzzNumber(final int number) {
        return number % buzzNumber == 0;
    }
}
