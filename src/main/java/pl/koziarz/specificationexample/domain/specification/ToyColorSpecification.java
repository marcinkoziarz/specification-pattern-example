package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.domain.entity.Toy;

public class ToyColorSpecification extends AbstractSpecification<Toy> {

	private String color;

	public ToyColorSpecification(String color) {
		super();
		this.color = color;
	}

	@Override
	public boolean isSatisfiedBy(Toy t) {
		return t.getColor().equals(color);
	}

}
