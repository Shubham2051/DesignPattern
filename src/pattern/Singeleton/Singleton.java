package pattern.Singeleton;

public class Singleton {

    // Class which is based on Singleton Design pattern
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private static Singleton instance=null;

    public static Singleton  getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }

        return instance;
    }




    private  Singleton() {
    }
}
