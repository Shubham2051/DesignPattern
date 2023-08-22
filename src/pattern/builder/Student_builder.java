package pattern.builder;

public class Student_builder {
    private String name;
    private String address;
    private double psp;
    private int age;
    private String gender;

    private Student_builder(Builder_std builder){
        this.name=builder.getName();
        this.address=builder.getAddress();
        this.age=builder.getAge();
        this.psp=builder.getPsp();
        this.gender=builder.getGender();
    }

    public static Builder_std getBuilder(){
        return new Builder_std();
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


    public static class Builder_std {
        private String name;
        private String address;
        private double psp;
        private int age;
        private String gender;

        public String getName() {
            return name;
        }

        public Builder_std setName(String name) {
            this.name = name;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Builder_std setAddress(String address) {
            this.address = address;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder_std setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder_std setAge(int age) {
            this.age = age;
            return this;
        }

        public String getGender() {
            return gender;
        }

        public Builder_std setGender(String gender) {
            this.gender = gender;
            return this;
        }

        private boolean validate(){
            if(age>24 && psp<70){
                return false;
            }
            if(age<18){
                return false;
            }
            return true;
        }

        public Student_builder Build() throws Exception {
            if(validate()){
                return new Student_builder(this);
            }
            else{
                throw new Exception("Did not validate");
            }
        }


    }

}
