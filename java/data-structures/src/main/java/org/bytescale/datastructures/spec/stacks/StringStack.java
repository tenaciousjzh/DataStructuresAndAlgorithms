package org.bytescale.datastructures.spec.stacks;

public interface StringStack {

	public abstract void push(String item);

	public abstract String pop();

	public abstract boolean isEmpty();

	public abstract int size();

}