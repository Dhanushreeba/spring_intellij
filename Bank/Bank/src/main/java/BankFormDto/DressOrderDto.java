package BankFormDto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DressOrderDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 max 30")
    private String name;

    @Max(9999999999L)
    private Long phone;

    @NotNull(message = "address cannot be Null")
    @Size(min=3,max=300,message = "address should be min 3 max 300")
    private String address;

    @NotEmpty(message = "gender can not be Empty")
    private String paymentType;

    @Min(30)
    @Max(10000)
    private Integer totalPrice;

    @NotEmpty(message = "Please check confirm")
    private String conform;

    @Override
    public String toString() {
        return "DressOrderDto{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", totalPrice=" + totalPrice +
                ", conform='" + conform + '\'' +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getConform() {
        return conform;
    }

    public void setConform(String conform) {
        this.conform = conform;
    }
}
