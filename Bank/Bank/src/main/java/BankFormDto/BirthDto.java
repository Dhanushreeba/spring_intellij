package BankFormDto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BirthDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 30")
    private String name;

    @NotEmpty(message = "gender can not be Empty")
    private String gender;

    @NotNull(message = "Please enter dateOfBirth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotNull(message = "fatherName cannot be Null")
    @Size(min=3,max=40,message = "fatherName should be min 3 max 40")
    private String fatherName;

    @NotNull(message = "motherName cannot be Null")
    @Size(min=3,max=50,message = "motherName should be min 3 max 50")
    private String motherName;

    @NotNull(message = "placeOfBirth cannot be Null")
    @Size(min=3,max=80,message = "placeOfBirth should be min 3 max 80")
    private String placeOfBirth;

    @NotNull(message = "address cannot be Null")
    @Size(min=3,max=300,message = "address should be min 3 max 300")
    private String address;

    @NotEmpty(message = "Please check confirm")
    private String confirm;

    public BirthDto(){

        System.out.println("No param constr form BirthDto");
    }

    @Override
    public String toString() {
        return "BirthDto{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", confirm='" + confirm + '\'' +
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
