
package com.dao;

import com.pojo.Result;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ResultDao {
    public boolean saveResult(Result result){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(result);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean updateResult(Result result){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(result);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean deleteResult(Result result){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(result);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }  
//    public Result findOneResult(Str){
//        try{
//            Session s=NewHibernateUtil.getSessionFactory().openSession();
//            s.beginTransaction();
//            Query q=s.createQuery("FROM Student where studentId=:s");
//            q.setParameter("s", studentId);
//            List<Student> list=q.list();
//            Student student=list.get(0);
//            s.getTransaction().commit();
//            s.close();
//            return student;
//        }catch(Exception e){
//            return null;
//        }
//    }
    public List<Result> findStudentResults(String studentId, String courseId){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q=s.createQuery("FROM Result where student_id=:s and course_id=:c");
            q.setParameter("s", studentId);
            q.setParameter("c", courseId);
            List<Result> resultList=q.list();
            s.getTransaction().commit();
            s.close();
            return resultList;
        }catch(Exception e){
            return null;
        }
    }
}
