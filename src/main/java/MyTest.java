import java.math.BigInteger;

public class MyTest {
    public static void main(String args[])throws Exception{
        System.out.println(fib(BigInteger.valueOf(50)));
    }

    public static BigInteger fib(BigInteger n){
        if(n.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        if(n.equals(BigInteger.ONE)) return BigInteger.ONE;
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.valueOf(2))));
    }
}
