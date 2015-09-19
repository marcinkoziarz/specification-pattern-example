package pl.koziarz.specificationexample.domain.entity;

import java.util.HashSet;
import java.util.Set;

public class Child {
	private String name;
	private int age;
	private Set<Toy> favouriteToys = new HashSet<>();
	
	public Child(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Child() {
	}
	
	public int getAge() {
		return age;
	}
	
	public Set<Toy> getFavouriteToys() {
		return favouriteToys;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setFavouriteToys(Set<Toy> favouriteToys) {
		this.favouriteToys = favouriteToys;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Child [name=" + name + ", age=" + age + ", favouriteToys=" + favouriteToys + "]";
	}
	
}
