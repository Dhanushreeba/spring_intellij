package BankFormDto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WeddingMakeupDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 30")
    private String name;

    @NotNull(message = "Phone number cannot be null")
    @Min(value = 1000000000L, message = "Phone number must be at least 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be at most 10 digits")
    private Long phone;

    @NotNull(message = "cost cannot be null")
    @Min(value = 3, message = "cost must be at least 3 digits")
    @Max(value = 100000, message = "cost number must be at most 100000 digits")
    private Integer cost;

    @NotNull(message = "noOfPeople cannot be null")
    @Min(value = 1, message = "noOfPeople must be at least 1 digits")
    @Max(value = 5, message = "noOfPeople number must be at most 5 digits")
    private Integer noOfPeople;

    @NotNull(message = "address cannot be Null")
    @Size(min=3,max=300,message = "address should be min 3 max 300")
    private String address;

    public WeddingMakeupDto(){

        System.out.println("no param constr for WeddingMakeupDto");
    }

    @Override
    public String toString() {
        return "WeddingMakeupDto{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", cost=" + cost +
                ", noOfPeople=" + noOfPeople +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
