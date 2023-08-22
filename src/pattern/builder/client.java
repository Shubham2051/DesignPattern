package pattern.builder;

public class client {
    public static void main(String[] args) throws Exception {
        Builder student =new Builder();
        student.setName("Shubham");
        student.setAddress("Patiala");
        student.setAge(23);
        student.setGender("Male");
        student.setPsp(65);


        // Builder class in diffrent files
        Student student1= Student.getBuilder().setName("Shubham").setAddress("Patiala").setAge(26).setPsp(78).setGender("Male").Build();
        System.out.println(student1);

        // builder class in Same Class
        Student_builder student2= Student_builder.getBuilder().setName("Shubham").setAddress("Patiala").setAge(26).setPsp(78).setGender("Male").Build();
        System.out.println(student2);




    }
}
