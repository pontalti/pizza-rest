package com.builder;

/**
 * @author Pontalti X
 *
 */
public abstract class GenericFoodBuilder<T, B> {

	protected String 	name;
	protected Integer 	size;
	protected Boolean 	cheese;
	protected Boolean 	tomato;
	protected Boolean 	bacon;
	
	public abstract B 	setSize(Integer size);
	public abstract B 	withCheese(Boolean cheese);
	public abstract B 	withTomato(Boolean tomato);
	public abstract B 	withBacon(Boolean bacon);
	public abstract T 	build();
	
	public String getName() {
		return name;
	}
	public Integer getSize() {
		return size;
	}

	public Boolean getCheese() {
		return cheese;
	}

	public Boolean getTomato() {
		return tomato;
	}

	public Boolean getBacon() {
		return bacon;
	}
	
}