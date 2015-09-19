package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.domain.entity.Child;

public class ChildNameSpecification extends AbstractSpecification<Child> {

	private String name;
	
	public ChildNameSpecification(String name) {
		this.name=name;
	}
	
	@Override
	public boolean isSatisfiedBy(Child t) {
		return t.getName().equals(name);
	}

}
