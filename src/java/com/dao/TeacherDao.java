
package com.dao;

import com.pojo.Teacher;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class TeacherDao {
    private String msg;
    public boolean saveTeacher(Teacher teacher){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(teacher);
            s.getTransaction().commit();
            s.close();
            msg="Successful";
            return true;
        }catch(Exception e){
            msg=e.toString();
            return false;
        }
    }
    public boolean updateTeacher(Teacher teacher){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(teacher);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean deleteTeacher(Teacher teacher){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(teacher);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }  
    public Teacher findOneTeacher(String teacherId){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q=s.createQuery("FROM Teacher where teacherId=:t");
            q.setParameter("t", teacherId);
            List<Teacher> list=q.list();
            Teacher teacher=list.get(0);
            s.getTransaction().commit();
            s.close();
            return teacher;
        }catch(Exception e){
            return null;
        }
    }
    public List<Teacher> findAllTeachers(){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q=s.createQuery("FROM Teacher");
            List<Teacher> teachersList=q.list();
            s.getTransaction().commit();
            s.close();
            return teachersList;
        }catch(Exception e){
            return null;
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
