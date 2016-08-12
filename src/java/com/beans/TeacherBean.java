package com.beans;

import com.dao.TeacherDao;
import com.dao.UserRoleDao;
import com.pojo.Address;
import com.pojo.Teacher;
import com.pojo.UserRole;
import com.util.ImageManagement;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class TeacherBean {

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
    public TeacherDao td = new TeacherDao();

    //Variable for address
    private String country;
    private String district;
    private String thana;
    private String mahalla;
    private String road;
    private String house;
    private String flatNo;

    private UserRole userRole = new UserRole();
    UserRoleDao urd = new UserRoleDao();
    private UploadedFile upFile;
    private List<Teacher> teacherList;
    
    public String saveTeacher() {
        this.image=new ImageManagement().copyImage(upFile, teacherId);
        Address add = new Address(country, district, thana, mahalla, road, house, flatNo);
        Teacher teacher = new Teacher(teacherId, add, firstName, lastName, dob, age, gender, email, phone, specialization, image, courseses);
        userRole.setUserId(teacherId);
        userRole.setPassword(userRole.getPassword());
        userRole.setRole("teacher");
        if (td.saveTeacher(teacher) && urd.saveUserRole(userRole)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration Successful"));
            return "success";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration Failed. " + td.getMsg()));
            return "error";
        }
    }
    
    
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set getCourseses() {
        return courseses;
    }

    public void setCourseses(Set courseses) {
        this.courseses = courseses;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getMahalla() {
        return mahalla;
    }

    public void setMahalla(String mahalla) {
        this.mahalla = mahalla;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UploadedFile getUpFile() {
        return upFile;
    }

    public void setUpFile(UploadedFile upFile) {
        this.upFile = upFile;
    }

    public List<Teacher> getTeacherList() {
        teacherList=new TeacherDao().findAllTeachers();
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
