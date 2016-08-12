package com.pojo;
// Generated Jul 24, 2016 8:34:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Teacher generated by hbm2java
 */
public class Teacher  implements java.io.Serializable {


     private String teacherId;
     private Address address;
     private String firstName;
     private String lastName;
     private Date dob;
     private int age;
     private String gender;
     private String email;
     private String phone;
     private String specialization;
     private String image;
     private Set courseses = new HashSet(0);

    public Teacher() {
    }

	
    public Teacher(String teacherId, String lastName, Date dob, int age, String gender, String email, String phone, String specialization, String image) {
        this.teacherId = teacherId;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.specialization = specialization;
        this.image = image;
    }
    public Teacher(String teacherId, Address address, String firstName, String lastName, Date dob, int age, String gender, String email, String phone, String specialization, String image, Set courseses) {
       this.teacherId = teacherId;
       this.address = address;
       this.firstName = firstName;
       this.lastName = lastName;
       this.dob = dob;
       this.age = age;
       this.gender = gender;
       this.email = email;
       this.phone = phone;
       this.specialization = specialization;
       this.image = image;
       this.courseses = courseses;
    }
   
    public String getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSpecialization() {
        return this.specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Set getCourseses() {
        return this.courseses;
    }
    
    public void setCourseses(Set courseses) {
        this.courseses = courseses;
    }




}


