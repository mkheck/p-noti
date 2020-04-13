package com.thehecklers.pizzanotifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@SpringBootApplication
public class PizzaNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaNotifierApplication.class, args);
	}

}

/*
@Configuration
class PizzaNotifier {
	@Bean
	Consumer<Pizza> notifyCustomer() {
		return System.out::println;
	}
}
*/

@Configuration
class PizzaNotifier {
	@Bean
	Consumer<Flux<Pizza>> notifyCustomer() {
		//return System.out::println;
		return flux -> flux.subscribe(pizza -> System.out.println("   >>> Your pizza is being prepared: " + pizza.description()));
	}
}


//@Data
//@AllArgsConstructor
record Pizza (Long id, String description) {}