package com.pojo;
// Generated Jul 24, 2016 8:34:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private String studentId;
     private Address address;
     private String firstName;
     private String lastName;
     private Date dob;
     private int age;
     private String gender;
     private String phone;
     private String email;
     private String image;
     private Set courseEnrolls = new HashSet(0);
     private Set results = new HashSet(0);

    public Student() {
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }

	
    public Student(String studentId, String firstName, String lastName, Date dob, int age, String gender, String phone, String email, String image) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }
    public Student(String studentId, Address address, String firstName, String lastName, Date dob, int age, String gender, String phone, String email, String image, Set courseEnrolls, Set results) {
       this.studentId = studentId;
       this.address = address;
       this.firstName = firstName;
       this.lastName = lastName;
       this.dob = dob;
       this.age = age;
       this.gender = gender;
       this.phone = phone;
       this.email = email;
       this.image = image;
       this.courseEnrolls = courseEnrolls;
       this.results = results;
    }
   
    public String getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Set getCourseEnrolls() {
        return this.courseEnrolls;
    }
    
    public void setCourseEnrolls(Set courseEnrolls) {
        this.courseEnrolls = courseEnrolls;
    }
    public Set getResults() {
        return this.results;
    }
    
    public void setResults(Set results) {
        this.results = results;
    }




}


