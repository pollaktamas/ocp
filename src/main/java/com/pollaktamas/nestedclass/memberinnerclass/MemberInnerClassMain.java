package com.pollaktamas.nestedclass.memberinnerclass;

public class MemberInnerClassMain {
    public static void main(String[] args) {
        Outer hello = new Outer("Hello!");
        hello.initInner();
        hello.callInner();
        Outer bye = new Outer("Bye!");
        bye.initInner();
        bye.callInner();

        Outer.Inner innerReference = new Outer("Hello - inner reference").initInner();
        innerReference.go();

        Outer outer = new Outer("Hello - inner by constructor method");
        Outer.Inner in = outer.new Inner();
        in.go();

        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.printNums();
    }
}
