package pl.koziarz.specificationexample.domain.entity;

public class Toy {
	private String name;
	private String color;
	private ToyType type;
	private double weight;
	
	
	public Toy(String name, String color, ToyType type, double weight) {
		super();
		this.name = name;
		this.color = color;
		this.type = type;
		this.weight = weight;
	}

	public Toy() {
	}
	
	public String getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public ToyType getType() {
		return type;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(ToyType type) {
		this.type = type;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Toy [name=" + name + ", color=" + color + ", type=" + type + ", weight=" + weight + "]";
	}
}
