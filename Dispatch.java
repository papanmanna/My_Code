class A{
	void callMe()
	{
		Sysytem.out.println("A");
	}
}
class B extends A{
	void callMe()
	{
		Sysytem.out.println("b");
	}
}

class C extend A{
	void callMe()
	{
		Sysytem.out.println("c");
	}
}





class Dispatch{
public static void main(String []args){
	A a =new A();
	B b=new B();
	C c new C();
	A a1;
	a1=a;
	a1.callMe();
	a1=b;
	a1.callMe();
	a1=c;
	a1.callMe();
}
}	