
package com.dao;

import com.pojo.CourseDetails;
import com.pojo.Courses;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CourseDetailsDao {
    
    public boolean saveCourseDetails(CourseDetails courseDetails) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(courseDetails);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCourseDetails(CourseDetails courseDetails) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(courseDetails);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteCourseDetails(CourseDetails courseDetails) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(courseDetails);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public List<CourseDetails> findOneCourseDetails(String coursesId) {
//        try {
//            Session s = NewHibernateUtil.getSessionFactory().openSession();
//            s.beginTransaction();
//            Query q = s.createQuery("FROM CourseDetails where courseId=:s");
//            q.setParameter("s", coursesId);
//            List<Courses> list = q.list();
//            Courses courses = list.get(0);
//            s.getTransaction().commit();
//            s.close();
//            return courses;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    //    public List<CourseDetails> findOneCourseDetails(String coursesId) {
//        try {
//            Session s = NewHibernateUtil.getSessionFactory().openSession();
//            s.beginTransaction();
//            Query q = s.createQuery("FROM CourseDetails where courseId=:s");
//            q.setParameter("s", coursesId);
//            List<Courses> list = q.list();
//            Courses courses = list.get(0);
//            s.getTransaction().commit();
//            s.close();
//            return courses;
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public String findCourseVedio(String course, String week, String lecture) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Courses courses=new Courses();
            courses.setCourseId(course);
            Query q = s.createQuery("FROM CourseDetails where course_id:c and week_no:w and lecture_no:l");
            q.setParameter("c", course);
            q.setParameter("w", week);
            q.setParameter("l", lecture);
            List<CourseDetails> courseDetailsList = q.list();
            CourseDetails cd=courseDetailsList.get(0);
            String vedio=cd.getVedio();
            s.getTransaction().commit();
            s.close();
            return vedio;
        } catch (Exception e) {
            return "";
        }
    }
    public String findCourseDocument(String course, String week, String lecture) {
        try {
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Courses courses=new Courses();
            courses.setCourseId(course);
            Query q = s.createQuery("FROM CourseDetails where course_id:c and week_no:w and lecture_no:l");
            q.setParameter("c", course);
            q.setParameter("w", week);
            q.setParameter("l", lecture);
            List<CourseDetails> courseDetailsList = q.list();
            CourseDetails cd=courseDetailsList.get(0);
            String document=cd.getDocument();
            s.getTransaction().commit();
            s.close();
            return document;
        } catch (Exception e) {
            return "";
        }
    }
}
