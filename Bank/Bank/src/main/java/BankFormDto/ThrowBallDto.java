package BankFormDto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;

public class ThrowBallDto {

    @NotNull(message = "participantName cannot be Null")
    @Size(min=3,max=30,message = "participantName should be min 3 max 30")
    private String participantName;

    @NotNull(message = "age cannot be null")
    @Min(value = 15, message = "age must be at least 15 digits")
    @Max(value = 40, message = "age number must be at most 40 digits")
    private Integer age;

    @NotNull(message = "Phone number cannot be null")
    @Min(value = 1000000000L, message = "Phone number must be at least 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be at most 10 digits")
  //  @Pattern(regexp="//10",message="Phone number cant not be null")
    //@Max(value = 9999999999L)
    private Long phone;

    @NotNull(message = "fatherName cannot be Null")
    @Size(min=3,max=30,message = "fatherName should be min 3 max 30")
    private String fatherName;

    @NotEmpty(message = "participationLevel can not be Empty")
    private String participationLevel;

    @Override
    public String toString() {
        return "ThrowBallDto{" +
                "participantName='" + participantName + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", fatherName='" + fatherName + '\'' +
                ", participationLevel='" + participationLevel + '\'' +
                '}';
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getParticipationLevel() {
        return participationLevel;
    }

    public void setParticipationLevel(String participationLevel) {
        this.participationLevel = participationLevel;
    }
}
