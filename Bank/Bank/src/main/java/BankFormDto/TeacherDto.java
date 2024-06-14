package BankFormDto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 30")
    private String name;

    @NotEmpty(message = "gender can not be Empty")
    private String gender;

    @NotNull(message = "School cannot be Null")
    @Size(min=3,max=30,message = "SchoolName should be min 3 max 50")
    private String schoolName;

    @Max(9999999999L)
    private String phone;

    @NotEmpty(message = "Please check accept")
    private String accept;

    public TeacherDto(){

        System.out.println("no param constr for TeacherDto");
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", phone='" + phone + '\'' +
                ", accept='" + accept + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
       this.gender = gender;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }
}
