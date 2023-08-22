package pattern.builder;

public class Student {
    private String name;
    private String address;
    private double psp;
    private int age;
    private String gender;

    public Student(Builder builder){
        this.name=builder.getName();
        this.address=builder.getAddress();
        this.age=builder.getAge();
        this.psp=builder.getPsp();
        this.gender=builder.getGender();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", psp=" + psp +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
