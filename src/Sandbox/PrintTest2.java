package Sandbox;
/* Method and Constructor Invocation order */
class A {
    static {
        System.out.println("Inside A Static");
    }
    {
        System.out.println("Inside A Init");
    }
    A() {
        System.out.println("A with no-arg constructor");
    }

    protected void show() {
        System.out.println("a.show()");
    }

    public static void methodA() {
        System.out.println("A.method()");
    }
}

class B extends A {
    static {
        System.out.println("Inside B Static");
    }

    {
        System.out.println("Inside B Init");
    }

    B() {
        // super();
        System.out.println("B with no-arg constructor");
    }

    public void show() {
        System.out.println("b.show()");
        super.show();
    }

    public static void methodA() {
        System.out.println("B_A.method()");
        A.methodA();
    }
}

public class PrintTest2 {
    public static void main(String[] args) {
        B b = new B();
        b.show();
        B.methodA();
    }
}