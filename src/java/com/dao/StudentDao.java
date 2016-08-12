
package com.dao;

import com.pojo.Student;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class StudentDao {
    public boolean saveStudent(Student student){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(student);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean updateStudent(Student student){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(student);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean deleteStudent(Student student){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(student);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }  
    public Student findOneStudent(String studentId){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q=s.createQuery("FROM Student where studentId=:s");
            q.setParameter("s", studentId);
            List<Student> list=q.list();
            Student student=list.get(0);
            s.getTransaction().commit();
            s.close();
            return student;
        }catch(Exception e){
            return null;
        }
    }
    public List<Student> findAllStudents(){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q=s.createQuery("FROM Student");
            List<Student> studentsList=q.list();
            s.getTransaction().commit();
            s.close();
            return studentsList;
        }catch(Exception e){
            return null;
        }
    }
}
