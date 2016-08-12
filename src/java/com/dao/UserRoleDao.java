
package com.dao;

import com.pojo.UserRole;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserRoleDao {
    
    public boolean saveUserRole(UserRole userRole){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(userRole);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean updateUserRole(UserRole userRole){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(userRole);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean deleteUserRole(UserRole userRole){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(userRole);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }  
    public UserRole findOneUserRole(String userId, String password){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q=s.createQuery("FROM UserRole where userId=:i and password=:p");
            q.setParameter("i", userId);
            q.setParameter("p", password);
            List<UserRole> list=q.list();
            UserRole userRole=list.get(0);
            s.getTransaction().commit();
            s.close();
            return userRole;
        }catch(Exception e){
            return null;
        }
    }
    public List<UserRole> findAllUserRoles(){
        try{
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Query q=s.createQuery("FROM UserRole");
            List<UserRole> userRoleList=q.list();
            s.getTransaction().commit();
            s.close();
            return userRoleList;
        }catch(Exception e){
            return null;
        }
    }
}
