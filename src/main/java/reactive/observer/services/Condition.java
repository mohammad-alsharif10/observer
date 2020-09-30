package reactive.observer.services;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Condition<T> {

    public Supplier<Boolean> booleanExpression;
    public T action;

    public Condition(Supplier<Boolean> booleanExpression, T action) {
        this.booleanExpression = booleanExpression;
        this.action = action;
    }

    public static <T> Condition<T> ifStatement(Supplier<Boolean> condition, T action) {
        return new Condition<>(condition, action);
    }

    @SafeVarargs
    public static <T> Optional<T> match(Condition<T>... ifStatement) {
        return Stream.of(ifStatement)
                .filter(condition -> condition.booleanExpression.get())
                .findFirst()
                .map(condition -> condition.action);
    }
}
