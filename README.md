# specification-pattern-example
An example how to implement specification pattern in Java

## Specification Pattern - what it is?
Specification object represents conditions that should be met by an object of given type.
Specification must implement method ``isSatisfiedBy(Object o)`` that checks, whether object is meeting
expected conditions.
They are especially helpful when retrieving objects from Repositories
(a DAO object with simplified and precised responsibility).

## Performance?!
Well, in this example performance of checking specified elements by simply iterating through all of them is really bad.
It may be greatly improved by generating SQL (or HQL for Hibernate) statements. As you may expect, putting SQL/HQL code
directly into Specification objects is not that good practice, as it breaks clean separation of data from infrastructure.
One may choose to implement converters (have a look at Spring's ConversionService) that know how to convert every specification
and their combinations into SQL/HQL query.

## Example by example
Let's imagine a kindergarten management system. We have children who has their names, age and they like toys. Toys have their color, type and weight. Headmaster often wants to query the system for reports. As he doesn't know SQL (but knows a little Java) it would be nice to give him a set of tools to do his daily job in a convenient way.

In our system we have some toys: A red racing ferrari, red fire truck, white police car and a brown teddy bear named Timmy. Children have their preferences regarding toys. Johny (7 y.o.) likes all red cars. Second Johny likes only a white police car, while Max likes fire truck and a police car and Jenny likes only her fluffy Timmy.

Headmaster achieves his goals by using Specifications provided by his development team. They are a fine-grained conditions that are used to query system.

### Simple specification
Simplest form of specification may be the one that is satisfied by children of given name.
```java
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
```
So headmaster can create specification for finding all children named Johny:
```java
Specification<Child> findJohny = new ChildNameSpecification("Johny");
```

### Composite specifications
But what if headmaster wants to find children named Johny or Jenny?
Thanks to methods ``or()``, ``and()`` and ``not()`` specifications may be joined using these logic operations. Specification below allows to find all Johnys and Jennys in system:
```java
Specification<Child> findJohnyOrJenny = new ChildNameSpecification("Johny").or(new ChildNameSpecification("Jenny"));
```
Or, headmaster may find all children that are not named Johny:
```java
Specification<Child> findAllButJohny = new ChildNameSpecification("Johny").not();
```

### Gateway specifications
Headmaster can easily find all toys of given colour and all children named Johny. But how to mix specifications and find all Johnys who likes a white toy?
```java
Specification<Child> findJohny = new ChildNameSpecification("Johny");
Specification<Toy> findWhiteToy = new ToyColorSpecification("White");
```
Let's create a gateway specification for specifying liked toys for a child:
```java
public class ChildLikesSpecifiedToySpecification extends AbstractSpecification<Child> {
	private Specification<Toy> s;
	public ChildLikesSpecifiedToySpecification(Specification<Toy> s) {
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
```
Now using composite specifications headmaster may find all Johnys liking white toys:
```
Specification<Child> johnyLikingWhiteToy = new ChildNameSpecification("Johny")
    .and(new ChildLikesSpecifiedToySpecification(
        new ToyColorSpecification("White")
        )
    );
```


### Console output of example
```
Children whose name is Johny
Child [name=Johny, age=7, favouriteToys=[Toy [name=Ferrari, color=Red, type=ToyType [name=Racing car], weight=0.4], Toy [name=Los Angeles Fire Truck, color=Red, type=ToyType [name=Fire truck], weight=3.0]]]
Child [name=Johny, age=10, favouriteToys=[Toy [name=New York Police Department car, color=White, type=ToyType [name=Police car], weight=0.9]]]

Children who likes some red toys
Child [name=Johny, age=7, favouriteToys=[Toy [name=Ferrari, color=Red, type=ToyType [name=Racing car], weight=0.4], Toy [name=Los Angeles Fire Truck, color=Red, type=ToyType [name=Fire truck], weight=3.0]]]
Child [name=Max, age=8, favouriteToys=[Toy [name=Los Angeles Fire Truck, color=Red, type=ToyType [name=Fire truck], weight=3.0], Toy [name=New York Police Department car, color=White, type=ToyType [name=Police car], weight=0.9]]]

Children who likes a toy that's not red
Child [name=Jenny, age=5, favouriteToys=[Toy [name=Timmy The Bear, color=Brown, type=ToyType [name=Teddy Bear], weight=0.35]]]
Child [name=Max, age=8, favouriteToys=[Toy [name=Los Angeles Fire Truck, color=Red, type=ToyType [name=Fire truck], weight=3.0], Toy [name=New York Police Department car, color=White, type=ToyType [name=Police car], weight=0.9]]]
Child [name=Johny, age=10, favouriteToys=[Toy [name=New York Police Department car, color=White, type=ToyType [name=Police car], weight=0.9]]]

Johnys who like red toys
Child [name=Johny, age=7, favouriteToys=[Toy [name=Ferrari, color=Red, type=ToyType [name=Racing car], weight=0.4], Toy [name=Los Angeles Fire Truck, color=Red, type=ToyType [name=Fire truck], weight=3.0]]]

School Children
Child [name=Johny, age=7, favouriteToys=[Toy [name=Ferrari, color=Red, type=ToyType [name=Racing car], weight=0.4], Toy [name=Los Angeles Fire Truck, color=Red, type=ToyType [name=Fire truck], weight=3.0]]]
Child [name=Max, age=8, favouriteToys=[Toy [name=Los Angeles Fire Truck, color=Red, type=ToyType [name=Fire truck], weight=3.0], Toy [name=New York Police Department car, color=White, type=ToyType [name=Police car], weight=0.9]]]
Child [name=Johny, age=10, favouriteToys=[Toy [name=New York Police Department car, color=White, type=ToyType [name=Police car], weight=0.9]]]
```
