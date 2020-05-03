package visitorpatern;

public class VisitorPattern {
    public static void main(final String[] args) {
        //visit all children nodes
        StaticData.PERSON.acceptChildren(new PersonRecursiveVisitor() {
            @Override
            public void visit(Person person) {
                //visit and print the person name
                System.out.println(person.getName());
                super.visit(person);
            }
        });
    }
}