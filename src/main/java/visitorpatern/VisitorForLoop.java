package visitorpatern;

public class VisitorForLoop {
    public static void main(final String[] args) {
        //print all children using for loop
        VisitorForLoop.printAllChildren(StaticData.PERSON);
    }

    static void printAllChildren(Person person){
        for (Person person1: person.getChildren()){
            System.out.println(person1.getName());
            printAllChildren(person1);
        }
    }
}
