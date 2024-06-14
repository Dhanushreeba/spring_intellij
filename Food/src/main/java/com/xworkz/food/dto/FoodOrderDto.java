package com.xworkz.food.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;

public class FoodOrderDto {

    @NotNull(message = "Name cannot be Null")
    @Size(min=3,max=30,message = "Name should be min 3 character max 30 character")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name can only contain letters and spaces")
    private String name;

    @NotEmpty(message = "foodType can not be Empty")
    private String foodType;

    @NotEmpty(message = "orderSelection can not be Empty")
    private String orderSelection;

    @Size(min=5,max=300,message = "address should be min 5 max 300")
    private String address;

    @Min(value = 30, message = "Price should be greater than  30 rupees")
    @Max(value = 10000, message = "Price should be less than  10000 rupees")
    private Integer totalPrice;

    @NotEmpty(message = "Please check done")
    private String done;

    public FoodOrderDto(){
        System.out.println("Constructor for FoodOrderDto");
    }

    @Override
    public String toString() {
        return "FoodOrderDto{" +
                "name='" + name + '\'' +
                ", foodType='" + foodType + '\'' +
                ", orderSelection='" + orderSelection + '\'' +
                ", address='" + address + '\'' +
                ", totalPrice=" + totalPrice +
                ", done='" + done + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getOrderSelection() {
        return orderSelection;
    }

    public void setOrderSelection(String orderSelection) {
        this.orderSelection = orderSelection;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
