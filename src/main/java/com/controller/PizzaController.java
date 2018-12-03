package com.controller;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.builder.PizzaBuilder;
import com.model.Pizza;

/**
 * @author Pontalti X
 *
 */
@RestController
public class PizzaController {

	public PizzaController() {
		super();
	}
	
	@GetMapping(path = "/pizza", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Set<Pizza>> getAll() {
		ResponseEntity<Set<Pizza>> entity = new ResponseEntity<Set<Pizza>>(listPizza(), HttpStatus.OK);
		return entity;
	}
	
	@GetMapping(path = "/pizza/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Pizza> getPizza(@PathVariable("name") String name) {
		Pizza pizza = listPizza().stream().filter(x -> x.getName().equals(name) ).findFirst().orElse(null);
		ResponseEntity<Pizza> entity = null;
		if( null != pizza ) {
			entity = new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
		}else {
			entity = new ResponseEntity<Pizza>(pizza, HttpStatus.NO_CONTENT);
		}
		
		return entity;
	}
	
	private Set<Pizza> listPizza(){
		Set<Pizza> pizzas = new TreeSet<Pizza>();
		
		PizzaBuilder pizzaBuilder = new PizzaBuilder(10)
														.setName("Pizza 1")
														.withBacon(true)
														.withCheese(true)
														.withTomato(true);
		
		pizzas.add(pizzaBuilder.build());
		
		pizzaBuilder.setName("Pizza 4");
		pizzas.add(pizzaBuilder.build());
		
		pizzaBuilder.setName("Pizza 2");
		pizzas.add(pizzaBuilder.build());
		
		pizzaBuilder.setName("Pizza 5");
		pizzas.add(pizzaBuilder.build());
		
		return pizzas;
	}

}
