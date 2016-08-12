package com.pojo;
// Generated Jul 24, 2016 8:34:10 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
public class Address  implements java.io.Serializable {


     private Integer addressId;
     private String country;
     private String district;
     private String thana;
     private String mahalla;
     private String road;
     private String house;
     private String flatNo;
     private Set students = new HashSet(0);
     private Set teachers = new HashSet(0);

    public Address() {
    }

	
    public Address(String country, String district, String thana) {
        this.country = country;
        this.district = district;
        this.thana = thana;
    }
    public Address(String country, String district, String thana, String mahalla, String road, String house, String flatNo, Set students, Set teachers) {
       this.country = country;
       this.district = district;
       this.thana = thana;
       this.mahalla = mahalla;
       this.road = road;
       this.house = house;
       this.flatNo = flatNo;
       this.students = students;
       this.teachers = teachers;
    }
    public Address(String country, String district, String thana, String mahalla, String road, String house, String flatNo) {
       this.country = country;
       this.district = district;
       this.thana = thana;
       this.mahalla = mahalla;
       this.road = road;
       this.house = house;
       this.flatNo = flatNo;
    }
   
    public Integer getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getThana() {
        return this.thana;
    }
    
    public void setThana(String thana) {
        this.thana = thana;
    }
    public String getMahalla() {
        return this.mahalla;
    }
    
    public void setMahalla(String mahalla) {
        this.mahalla = mahalla;
    }
    public String getRoad() {
        return this.road;
    }
    
    public void setRoad(String road) {
        this.road = road;
    }
    public String getHouse() {
        return this.house;
    }
    
    public void setHouse(String house) {
        this.house = house;
    }
    public String getFlatNo() {
        return this.flatNo;
    }
    
    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }
    public Set getStudents() {
        return this.students;
    }
    
    public void setStudents(Set students) {
        this.students = students;
    }
    public Set getTeachers() {
        return this.teachers;
    }
    
    public void setTeachers(Set teachers) {
        this.teachers = teachers;
    }




}


