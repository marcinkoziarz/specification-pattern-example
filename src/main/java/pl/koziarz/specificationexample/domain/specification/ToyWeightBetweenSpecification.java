package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.domain.entity.Toy;

public class ToyWeightBetweenSpecification extends AbstractSpecification<Toy> {
	
	private int min;
	private int max;
	
	public ToyWeightBetweenSpecification(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public boolean isSatisfiedBy(Toy t) {
		return ( t.getWeight() > min && t.getWeight() < max );
	}

}
