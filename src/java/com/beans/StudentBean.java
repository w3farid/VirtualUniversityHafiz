
package com.beans;

import com.dao.StudentDao;
import com.dao.UserRoleDao;
import com.pojo.Address;
import com.pojo.Student;
import com.pojo.UserRole;
import com.util.ImageManagement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
@ManagedBean
@RequestScoped
public class StudentBean {
    private Student student =new Student();
    private UserRole userRole=new UserRole();
    private Address address=new Address();
    private UploadedFile upFile;
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
    public String saveStudent(){
        student.setStudentId(student.getStudentId());
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setDob(student.getDob());
        student.setAge(student.getAge());
        student.setGender(student.getGender());
        student.setEmail(student.getEmail());
        student.setPhone(student.getPhone());
        student.setImage(new ImageManagement().copyImage(upFile, student.getStudentId()));
        
        address.setCountry(address.getCountry());
        address.setDistrict(address.getDistrict());
        address.setThana(address.getThana());
        address.setMahalla(address.getMahalla());
        address.setRoad(address.getRoad());
        address.setHouse(address.getHouse());
        address.setFlatNo(address.getFlatNo());
        student.setAddress(address);
        
        userRole.setUserId(student.getStudentId());
        userRole.setPassword(userRole.getPassword());
        userRole.setRole("student");
        if(new StudentDao().saveStudent(student) && new UserRoleDao().saveUserRole(userRole)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration Successful"));
            return "success";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration Failed"));
            return "error";
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UploadedFile getUpFile() {
        return upFile;
    }

    public void setUpFile(UploadedFile upFile) {
        this.upFile = upFile;
    }
}
