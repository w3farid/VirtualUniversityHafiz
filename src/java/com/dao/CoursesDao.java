
package com.dao;

import com.pojo.Courses;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CoursesDao {

    public boolean saveCourses(Courses courses) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(courses);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCourses(Courses courses) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(courses);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteCourses(Courses courses) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(courses);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Courses findOneCourses(String coursesId) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery("FROM Courses where courseId=:s");
            q.setParameter("s", coursesId);
            List<Courses> list = q.list();
            Courses courses = list.get(0);
            s.getTransaction().commit();
            s.close();
            return courses;
        } catch (Exception e) {
            return null;
        }
    }


    public List<Courses> findAllCourses() {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery("FROM Courses");
            List<Courses> coursesList = q.list();
            s.getTransaction().commit();
            s.close();
            return coursesList;
        } catch (Exception e) {
            return null;
        }
    }
}
