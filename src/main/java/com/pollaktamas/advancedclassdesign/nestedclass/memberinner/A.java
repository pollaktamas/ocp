package com.pollaktamas.advancedclassdesign.nestedclass.memberinner;

public class A {
    private int num = 5;

    public class B {
        private int num = 6;

        public class C {
            private int num = 7;

            public void printNums() {
                System.out.println(this.num);
                System.out.println(B.this.num);
                System.out.println(A.this.num);
            }
        }
    }
}
