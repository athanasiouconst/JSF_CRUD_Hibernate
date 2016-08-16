/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import entity.*;
import org.hibernate.*;

/**
 *
 * @author costas
 */
public class Student_dao {

    public List<Student> getAll() {
        Session s = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        List<Student> lst = new ArrayList<>();
        try {

            s.beginTransaction();
            lst = s.createCriteria(Student.class).list();
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
        }
        return lst;
    }

    public void create(Student student) {
        Session s = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        try {
            s.beginTransaction();
            s.save(student);
            s.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void edit(Student student) {
        Session s = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        try {
            s.beginTransaction();
            s.update(student);
            s.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void remove(Student student) {
        Session s = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        try {
            s.beginTransaction();
            s.delete(student);
            s.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

}
