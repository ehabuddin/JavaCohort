/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import DAO.ClassRosterDAO;
import DAO.ClassRosterDAOFileImpl;
import DTO.Student;
import UI.ClassRosterView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdeha
 */
public class ClassRosterController {
    
    ClassRosterDAO dao;
    ClassRosterView view;
    
    public ClassRosterController(ClassRosterDAO dao, ClassRosterView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean playAgain = true;

        while (playAgain) {
            view.printMenu();
            int selection = view.getSelection();
            switch (selection) {
                case 1:
                    //List all StudentIds
                    List<Student> allStudents = dao.getAllStudents();
                    view.displayStudentList(allStudents);
                    break;
                case 2:
                    //Create new Student
                    Student ns = view.getNewStudent();
                    dao.addStudent(ns.getStudentId(), ns);
                    view.createSuccess();
                    break;
                case 3:
                    //View a student
                    Student myStudent = dao.getStudent(view.getStudentId());
                    view.printStudent(myStudent);
                    break;
                case 4:
                    //Remove a student
                    String studentId = view.getStudentId();
                    Student studentRemoved = dao.removeStudent(studentId);
                    view.displayRemoveStudent(studentRemoved);
                    break;
                case 5:
                    //exit
                    playAgain = false;
                    view.exitMsg();
                    break;
            }
        }
    }
}
