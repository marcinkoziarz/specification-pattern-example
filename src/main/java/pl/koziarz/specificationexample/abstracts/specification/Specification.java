package pl.koziarz.specificationexample.abstracts.specification;

public interface Specification<T> {
	public boolean isSatisfiedBy(T t);
	public Specification<T> and(Specification<T> t);
	public Specification<T> or(Specification<T> t);
	public Specification<T> not();
}
