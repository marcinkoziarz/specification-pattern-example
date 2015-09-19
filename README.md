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
