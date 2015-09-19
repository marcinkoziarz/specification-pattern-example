package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.domain.entity.Child;

public class ChildAgeBetweenInclSpecification extends AbstractSpecification<Child> {

	private int min;
	private int max;
	
	public ChildAgeBetweenInclSpecification( int min, int max ) {
		this.min=min;
		this.max=max;
	}

	@Override
	public boolean isSatisfiedBy(Child t) {
		return t.getAge()>=min && t.getAge()<=max;
	}
	
	
	
}
