package pl.koziarz.specificationexample.domain.specification;

import pl.koziarz.specificationexample.abstracts.specification.AbstractSpecification;
import pl.koziarz.specificationexample.abstracts.specification.Specification;
import pl.koziarz.specificationexample.domain.entity.Child;
import pl.koziarz.specificationexample.domain.entity.Toy;

public class ChildLikesSpecifiedToySpecifiaction extends AbstractSpecification<Child> {

	private Specification<Toy> s;
	
	public ChildLikesSpecifiedToySpecifiaction(Specification<Toy> s) {
		super();
		this.s = s;
	}

	@Override
	public boolean isSatisfiedBy(Child c) {
		for( Toy t : c.getFavouriteToys()) {
			if( s.isSatisfiedBy(t) )
				return true;
		}
		return false;
	}

}
