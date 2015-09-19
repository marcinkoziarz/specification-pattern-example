package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.abstracts.specification.Specification;
import pl.koziarz.specificationexample.domain.entity.Toy;
import pl.koziarz.specificationexample.domain.entity.ToyType;

public class ToyTypeNameSpecification extends AbstractSpecification<ToyType> {

	private String name;

	public ToyTypeNameSpecification(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean isSatisfiedBy(ToyType t) {
		return t.getName().equals(name);
	}

}
