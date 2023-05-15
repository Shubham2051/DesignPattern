package pattern.Singeleton;

public class client {
    public static void main(String[] args) {
        Singleton a=Singleton.getInstance();
        System.out.println(a);
        Singleton b=Singleton.getInstance();
        System.out.println(b);

    }
}
