package com.model;

import com.builder.PizzaBuilder;

/**
 * @author Pontalti X
 *
 */
public class Pizza  implements Comparable<Pizza>{

	private String 	name;
	private Integer size;
	private Boolean cheese;
	private Boolean tomato;
	private Boolean bacon;
	
	public Pizza(PizzaBuilder builder) {
		super();
		this.name		=	builder.getName();
		this.size		=	builder.getSize();
		this.cheese		=	builder.getCheese();
		this.tomato		= 	builder.getTomato();
		this.bacon		= 	builder.getBacon();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Boolean getCheese() {
		return cheese;
	}

	public void setCheese(Boolean cheese) {
		this.cheese = cheese;
	}

	public Boolean getTomato() {
		return tomato;
	}

	public void setTomato(Boolean tomato) {
		this.tomato = tomato;
	}

	public Boolean getBacon() {
		return bacon;
	}

	public void setBacon(Boolean bacon) {
		this.bacon = bacon;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", size=" + size + ", cheese=" + cheese + ", tomato=" + tomato + ", bacon="
				+ bacon + "]";
	}

	@Override
	public int compareTo(Pizza o) {
		return this.name.compareToIgnoreCase(o.getName());
	}

}