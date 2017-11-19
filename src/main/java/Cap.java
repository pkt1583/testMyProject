import java.util.ArrayList;
import java.util.List;

public class Cap {
    public static <E extends Number> List<? super E> process(List<E> nums){return null;}
    public static void main(String args[])
    {
        byte x = 64;
        int i;
        byte y;
        i = x << 2;
        y = (byte) (x << 2);
        System.out.print(i + " " + y);

    }
}
