package visitorpatern;

import java.util.Arrays;
import java.util.List;
import lombok.Data;

import java.util.Collections;

interface CarElement {
}

interface CarElementVisitor {
    void visit(Body car);
}

@Data
class Body implements CarElement {
    private String name;
    private List<Body> children;

    public static Body ofName(String name){
        Body body = new Body();
        body.setName(name);
        body.setChildren(Collections.EMPTY_LIST);
        return body;
    }

    public static Body ofChildren(List<Body> children){
        Body body = new Body();
        body.setChildren(children);
        return body;
    }

    public static Body of(String name, List<Body> children){
        Body body = new Body();
        body.setName(name);
        body.setChildren(children);
        return body;
    }

    public void acceptChildren(CarElementVisitor visitor) {
        myWalker( visitor, children);
    }

    public static void myWalker(CarElementVisitor visitor, List<Body> children) {
        for (Body child : children) {
            visitor.visit(child);
            myWalker(visitor, child.getChildren());
        }
    }

}

abstract class CarElementDoVisitor implements CarElementVisitor {
    @Override
    public void visit(Body body){}
}

public class VisitorDemo {
    public static void main(final String[] args) {
        Body body = Body.of("root", Arrays.asList(
                Body.ofName("foo1"),
                Body.ofName("bar1"),
                Body.of("baz1", Arrays.asList(
                        Body.ofName("foo2"),
                        Body.ofName("bar2"),
                        Body.of("baz2", Arrays.asList(
                                Body.ofName("foo3"),
                                Body.ofName("bar3"),
                                Body.of("baz3", Arrays.asList(
                                        Body.ofName("foo4"),
                                        Body.ofName("bar4"),
                                        Body.ofName("baz4")
                                ))
                        ))
                ))
        ));

        body.acceptChildren(new CarElementDoVisitor() {
            @Override
            public void visit(Body body) {
                //visit and print the node name
                System.out.println(body.getName());
                super.visit(body);
            }
        });
    }
}