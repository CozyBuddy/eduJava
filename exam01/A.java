package exam01;

public class A {
	
	    A() {
	        System.out.println("A 객체가 생성됨.");
	    }

	    class B {
	        B() {
	            System.out.println("B 객체가 생성됨.");
	            System.out.println(field1);
	        }
	        int field1=1;
	        void method1(){}
	    }

	    static class C {
	        C() {
	            System.out.println("C 객체가 생성됨.");
	            System.out.println(field2);
	        }
	        int field1=4;
	        static int field2=2;
	        void method1() {}
	        static void method2() {}
	    }

	    void method() {
	        class D {
	            D() {
	                System.out.println("D 객체가 생성됨.");
	                System.out.println(field1);
	            }
	            int field1;
	            void method1() {}
	        }
	        D d = new D();
	        d.field1 = 4;
	        d.method1();
	    }


	


}
