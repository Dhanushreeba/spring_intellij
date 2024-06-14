package BankFormDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 30")
    private String name;

    private String Gender;

    @NotNull(message = "School cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 30")
    private String school;

    public TeacherDto(){

        System.out.println("no param constr for TeacherDto");
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "name='" + name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
