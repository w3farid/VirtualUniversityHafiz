
package com.beans;

import com.dao.CourseDetailsDao;
import com.pojo.CourseDetails;
import com.pojo.Courses;
import com.util.ImageManagement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class CourseDetailsBean {
    private CourseDetails courseDetails=new CourseDetails();
    private Courses course=new Courses();
    private UploadedFile upVedio;
    private UploadedFile upDocument;
    private String vedioLink="../resources/images/userImages/page.avi";
    private String docLink="../resources/images/userImages/s.pdf";
    
    public String saveCourseDetails(){
        course.setCourseId(course.getCourseId());
        courseDetails.setCourses(course);
        courseDetails.setWeekNo(courseDetails.getWeekNo());
        courseDetails.setLectureNo(courseDetails.getLectureNo());
        String fileName=course.getCourseId()+courseDetails.getWeekNo()+courseDetails.getLectureNo();
        courseDetails.setVedio(new ImageManagement().copyImage(upVedio, fileName));
        courseDetails.setDocument(new ImageManagement().copyImage(upDocument, fileName));
        if(new CourseDetailsDao().saveCourseDetails(courseDetails)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Course Information Saved"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to Save"));
        }
        return "courseDetailsRegistration";
    }

    public void selectVedioJ111(){
        vedioLink=new CourseDetailsDao().findCourseVedio("j1", "1", "1");
    }
    public void selectDocumentJ111(){
        docLink=new CourseDetailsDao().findCourseDocument("j1", "1", "1");
    }
    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(CourseDetails courseDetails) {
        this.courseDetails = courseDetails;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public UploadedFile getUpVedio() {
        return upVedio;
    }

    public void setUpVedio(UploadedFile upVedio) {
        this.upVedio = upVedio;
    }

    public UploadedFile getUpDocument() {
        return upDocument;
    }

    public void setUpDocument(UploadedFile upDocument) {
        this.upDocument = upDocument;
    }

    public String getVedioLink() {
        return vedioLink;
    }

    public void setVedioLink(String vedioLink) {
        this.vedioLink = vedioLink;
    }

    public String getDocLink() {
        return docLink;
    }

    public void setDocLink(String docLink) {
        this.docLink = docLink;
    }
    
    
}
