package com.builder;

import com.model.Pizza;

/**
 * @author Pontalti X
 *
 */
public class PizzaBuilder extends GenericFoodBuilder<Pizza, PizzaBuilder>{
	
	public PizzaBuilder(Integer size) {
		super();
		this.size 	= size;
		this.cheese = Boolean.FALSE;
		this.tomato = Boolean.FALSE;
		this.bacon 	= Boolean.FALSE;
	}

	public PizzaBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public PizzaBuilder withCheese(Boolean cheese) {
		this.cheese = cheese;
		return this;
	}

	public PizzaBuilder withTomato(Boolean tomato) {
		this.tomato = tomato;
		return this;
	}

	public PizzaBuilder withBacon(Boolean bacon) {
		this.bacon = bacon;
		return this;
	}
	
	public PizzaBuilder setSize(Integer size) {
		this.size = size;
		return this;
	}

	public Pizza build() {
		return new Pizza(this);
	}
	
}