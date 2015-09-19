package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.domain.entity.Child;
import pl.koziarz.specificationexample.domain.entity.Toy;

public class ChildLikesToySpecification extends AbstractSpecification<Child> {
	
	private Toy toy;

	public ChildLikesToySpecification(Toy toy) {
		super();
		this.toy = toy;
	}

	@Override
	public boolean isSatisfiedBy(Child t) {
		return t.getFavouriteToys().contains(toy);
	}

}
