package BankFormDto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HomeDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 50")
    private String fullName;

    @NotEmpty(message = "kindOfProperty can not be Empty")
    private String kindOfProperty;

    @NotEmpty(message = "floorLevel can not be Empty")
    private String floorLevel;

    @NotEmpty(message = "noOfBedrooms do check above")
    private String noOfBedrooms;

    @Size(min=3,max=30,message = "address should be min 3 max 300")
    private String address;

    @Max(9999999999L)
    private Long phone;

   public HomeDto(){
       System.out.println("no param Constr for HomeDto");
    }

    @Override
    public String toString() {
        return "HomeDto{" +
                "FullName='" + fullName + '\'' +
                ", kindOfProperty='" + kindOfProperty + '\'' +
                ", floorLevel='" + floorLevel + '\'' +
                ", noOfBedrooms='" + noOfBedrooms + '\'' +
                ", address='" + address + '\'' +
                ", Phone=" + phone +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getKindOfProperty() {
        return kindOfProperty;
    }

    public void setKindOfProperty(String kindOfProperty) {
        this.kindOfProperty = kindOfProperty;
    }

    public String getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(String floorLevel) {
        this.floorLevel = floorLevel;
    }

    public String getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(String noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
