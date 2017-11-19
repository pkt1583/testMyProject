package am;

class A{
    int p=0;
    A(){
      sum(5);
    }

    public void sum(int i) {
        p+=i;
    }
}
class B extends A{
    B(){
        sum(6);
    }

    public void sum(int i){
        p=p*i;
    }
}

public class Test{
    public static void main(String[] args) {
        A a=new B();
        a.sum(5);
    }
}
