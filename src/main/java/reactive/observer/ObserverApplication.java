package reactive.observer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactive.observer.services.Condition;

import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class ObserverApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(ObserverApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String name = "mohammad";
        Function<Boolean, Supplier<Boolean>> urlData = aBoolean ->
                Condition.<Supplier<Boolean>>match(
                        Condition.ifStatement(
                                () -> "mohammad1".equals(name),
                                () -> {
                                    System.out.println("match found");
                                    return true;
                                }),
                        Condition.ifStatement(
                                () -> "mohammad".equals(name),
                                () -> {
                                    System.out.println("match found");
                                    return true;
                                })
                ).orElse(() -> false);
        urlData.apply(true).get();
    }
}
