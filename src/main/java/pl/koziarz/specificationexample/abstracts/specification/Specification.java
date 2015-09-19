package pl.koziarz.specificationexample.abstracts.specification;

public interface Specification<T> {
	public boolean isSatisfiedBy(T t);
}
