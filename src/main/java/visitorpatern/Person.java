package visitorpatern;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
class Person {
    private String name;
    private List<Person> children;

    @SuppressWarnings("unchecked")
    public static Person ofName(String name){
        Person person = new Person();
        person.setName(name);
        person.setChildren(Collections.EMPTY_LIST);
        return person;
    }

    public static Person of(String name, List<Person> children){
        Person person = new Person();
        person.setName(name);
        person.setChildren(children);
        return person;
    }

    public void acceptChildren(PersonRecursiveVisitor visitor) {
        myWalker( visitor, children);
    }

    public static void myWalker(PersonRecursiveVisitor visitor, List<Person> children) {
        for (Person child : children) {
            visitor.visit(child);
            myWalker(visitor, child.getChildren());
        }
    }

}
