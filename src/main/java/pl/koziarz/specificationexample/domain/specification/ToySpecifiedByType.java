package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.abstracts.specification.Specification;
import pl.koziarz.specificationexample.domain.entity.Toy;
import pl.koziarz.specificationexample.domain.entity.ToyType;

public class ToySpecifiedByType extends AbstractSpecification<Toy> {

	private Specification<ToyType> spec;

	public ToySpecifiedByType(Specification<ToyType> spec) {
		super();
		this.spec = spec;
	}
	
	public boolean isSatisfiedBy(Toy t) {
		return spec.isSatisfiedBy(t.getType());
	}
	
}
