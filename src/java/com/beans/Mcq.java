package com.beans;
// Generated Aug 10, 2016 4:11:33 PM by Hibernate Tools 4.3.1

import com.dao.ResultDao;
import com.pojo.Courses;
import com.pojo.Result;
import com.pojo.Student;
import com.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean
@RequestScoped
public class Mcq implements java.io.Serializable {

    private Integer id;
    private String courseId;
    private Integer QNo;
    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private String answer;
    private List<Mcq> mcqList = new ArrayList<Mcq>();
    private String[] correctAnswer = new String[3];
    private String[] givenAnswer = new String[3];
    private int totalQ=0;
    private int correctA=0;
    private float percent=0;
    private String studentId="";
    public Mcq() {
    }

    public String checkAnswer() {
        
        totalQ=getCorrectAnswer().length;
        correctA=0;
        String a;
        String b;
        for(int i=0; i<totalQ; i++){
            a=correctAnswer[i];
            b=givenAnswer[i];
            if(a.equalsIgnoreCase(b)){
                correctA=correctA+1;
            }
        }
        percent = (float)correctA*100/totalQ;
        saveResult();
        return "showResult";
    }
    
    public void saveResult(){
        Result result=new Result();
        result.setCourses(new Courses("j1"));
        result.setStudent(new Student(studentId));
        result.setWeek(1);
        result.setAssignment(95);
        result.setExam((int)percent);
        new ResultDao().saveResult(result);
    }

    public Mcq(String courseId, Integer QNo, String question, String optA, String optB, String optC, String optD, String answer) {
        this.courseId = courseId;
        this.QNo = QNo;
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.answer = answer;
    }

    public void findAllMcq() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Mcq");
        mcqList = q.list();
        s.getTransaction().commit();
        s.close();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getQNo() {
        return this.QNo;
    }

    public void setQNo(Integer QNo) {
        this.QNo = QNo;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptA() {
        return this.optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return this.optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return this.optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return this.optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Mcq> getMcqList() {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery("from Mcq");
            mcqList = q.list();
            s.getTransaction().commit();
            s.close();
        } catch (Exception e) {
        }
        return mcqList;
    }

    public void setMcqList(List<Mcq> mcqList) {
        this.mcqList = mcqList;
    }

    public String[] getCorrectAnswer() {
        int i = 0;
        for (Mcq m : mcqList) {
            correctAnswer[i++] = m.getAnswer();
        }
        return correctAnswer;
    }

    public void setCorrectAnswer(String[] correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String[] givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public int getTotalQ() {
        return totalQ;
    }

    public void setTotalQ(int totalQ) {
        this.totalQ = totalQ;
    }

    public int getCorrectA() {
        return correctA;
    }

    public void setCorrectA(int correctA) {
        this.correctA = correctA;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
