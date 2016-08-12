
package com.beans;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dao.UserRoleDao;
import com.pojo.Courses;
import com.pojo.Student;
import com.pojo.Teacher;
import com.pojo.UserRole;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean {
    private String userId;
    private String password;
    private String userRole;
    private Student student=new Student();
    private Teacher teacher=new Teacher();
    public String logout(){
        teacher=null;
        student=null;
        return "home";
    }
    
    public String checkLogin(){
        UserRole ur=new UserRoleDao().findOneUserRole(userId, password);
        if(ur != null){
            userRole=ur.getRole();
        }
        else{
            userRole="";
        }
        if(userRole.equalsIgnoreCase("student")){
            student = new StudentDao().findOneStudent(userId);
            return "student";
        }else if(userRole.equalsIgnoreCase("teacher")){
            teacher=new TeacherDao().findOneTeacher(userId);
            return "teacher";
        }else{
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid user name or password"));
            return "login";
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
