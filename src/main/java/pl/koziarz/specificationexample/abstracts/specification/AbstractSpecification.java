package pl.koziarz.specificationexample.abstracts.specification;

public abstract class AbstractSpecification<T> implements Specification<T> {
	
	public abstract boolean isSatisfiedBy(T t);
	
	@Override
	public Specification<T> or(Specification<T> s) {
		return new OrSpecification<T>(this,s);
	}

	@Override
	public Specification<T> and(Specification<T> s) {
		return new AndSpecification<T>(this,s);
	}

	@Override
	public Specification<T> not() {
		return new NotSpecification<T>(this);
	}

}
