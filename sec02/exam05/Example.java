package sec02.exam05;

public class Example {
	public static void main(String[] args) {
		ImplementationC imp = new ImplementationC();
		
		InterfaceA ia =imp;
		ia.methodA();
		System.out.println();
		
		InterfaceB ib = imp;
		ib.methodB();
		System.out.println();
		
		InterfaceC ic = imp;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}

}
