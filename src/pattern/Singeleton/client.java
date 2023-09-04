package pattern.Singeleton;

public class client {
    public static void main(String[] args) {
        Singleton a=Singleton.getInstance();
        System.out.println(a);
        Singleton b=Singleton.getInstance();
        System.out.println(b);
        //this is test project

        Singelton_enum a_enum=Singelton_enum.INSTANCE;
        System.out.println(a_enum.hashCode());
        Singelton_enum b_enum=Singelton_enum.INSTANCE;
        System.out.println(b_enum.hashCode());

    }
}
