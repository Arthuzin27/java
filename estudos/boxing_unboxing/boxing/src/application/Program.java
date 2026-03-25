package application;
public class Program{
    public static void main(String[] args) {
        
        int x = 20;

        Object obj = x;

        System.out.println(obj);

        int y = 2 * (int) obj;

        System.out.println(y);
    }
}