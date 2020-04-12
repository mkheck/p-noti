package com.thehecklers.pizzanotifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
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
		return flux -> flux.subscribe(pizza -> System.out.println("   >>> Your pizza is being prepared: " + pizza.getDescription()));
	}
}


@Data
@AllArgsConstructor
class Pizza {
	private final Long id;
	private final String description;
}