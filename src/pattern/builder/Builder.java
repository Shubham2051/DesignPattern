package pattern.builder;

public class Builder {
    private String name;
    private String address;
    private double psp;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }

    public double getPsp() {
        return psp;
    }

    public Builder setPsp(double psp) {
        this.psp = psp;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Builder setGender(String gender) {
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

    public Student Build() throws Exception {
        if(validate()){
          return new Student(this);
        }
        else{
            throw new Exception("Did not validate");
        }
    }


}
