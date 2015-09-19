package pl.koziarz.specificationexample.domain.entity;

public class ToyType {
	private String name;
	
	public ToyType(String name) {
		super();
		this.name = name;
	}

	public ToyType() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ToyType [name=" + name + "]";
	}
}
