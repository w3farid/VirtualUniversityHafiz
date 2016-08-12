
package com.beans;

import com.dao.CoursesDao;
import com.pojo.Courses;
import com.pojo.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CoursesBean {
    private Courses cources=new Courses();
    private Teacher teacher=new Teacher();
    private List<Courses> coursesList=new ArrayList<Courses>();
    public String saveCourses(){
        cources.setCourseId(cources.getCourseId());
        cources.setCourseName(cources.getCourseName());
        cources.setStartDate(cources.getStartDate());
        cources.setEndDate(cources.getEndDate());
        teacher.setTeacherId(teacher.getTeacherId());
        cources.setTeacher(teacher);
        if(new CoursesDao().saveCourses(cources)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Course Created Successful"));
            return "success";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed"));
            return "error";
        }
    }

    public Courses getCources() {
        return cources;
    }

    public void setCources(Courses cources) {
        this.cources = cources;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Courses> getCoursesList() {
        coursesList=new CoursesDao().findAllCourses();
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
