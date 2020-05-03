package visitorpatern;

import java.util.Arrays;

public class StaticData {
    final public static Person PERSON = Person.of("root", Arrays.asList(
            Person.ofName("foo1"),
            Person.ofName("bar1"),
            Person.of("baz1", Arrays.asList(
                    Person.ofName("foo2"),
                    Person.ofName("bar2"),
                    Person.of("baz2", Arrays.asList(
                            Person.ofName("foo3"),
                            Person.ofName("bar3"),
                            Person.of("baz3", Arrays.asList(
                                    Person.ofName("foo4"),
                                    Person.ofName("bar4"),
                                    Person.ofName("baz4")
                            ))
                    ))
            ))
    ));

}
