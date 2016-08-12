
package com.beans;

import com.dao.ResultDao;
import com.pojo.Result;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ResultBean {
    private List<Result> resultList;
    private String studentId;
    private String courseId;

    public ResultBean() {
    }
    
    public List<Result> getResultList() {
        resultList=new ResultDao().findStudentResults(studentId, courseId);
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
}
