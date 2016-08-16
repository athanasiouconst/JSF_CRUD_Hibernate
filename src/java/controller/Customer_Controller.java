/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import model.*;
import entity.*;

/**
 *
 * @author costas
 */
@ManagedBean(name = "studentBean")
@SessionScoped
public class Customer_Controller {

    /**
     * Creates a new instance of Customer_Controller
     */
    private List<Student> lst = new ArrayList<>();

    public List<Student> getLst() {
        Student_dao dao = new Student_dao();
        return dao.getAll();
    }

    public void setLst(List<Student> lst) {
        this.lst = lst;
    }

    private Student student = new Student();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void remove(Student student) {
        Student_dao cdao = new Student_dao();
        cdao.remove(student);
    }

    public String insert() {
        Student_dao dao = new Student_dao();
        dao.create(student);
        return "index";
    }

    public String edit(Student student) {

        this.student = student;
        return "editStudent";
    }

    public String save() {
        Student_dao dao = new Student_dao();
        dao.edit(student);
        return "index";
    }
}
