package BankFormDto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BankDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 30")
    private String name;

    @Size(min=1,max=2,message="Age should be greater than 2")
    private String age;

    @Size(min=5,max=30,message = "email should be min 5 and  max 30")
    private String email;

   /* @Min(1)*/
    @Max(9999999999L)
    private Long phone;

    @NotEmpty(message = "gender can not be Empty")
    private String gender;

    @NotEmpty(message = "Please check accept")
    private String accept;

   public BankDto(){
       System.out.println("no param constr for BankDto");
    }

    @Override
    public String toString() {
        return "BankDto{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", gender='" + gender + '\'' +
                ", accept='" + accept + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }
}
