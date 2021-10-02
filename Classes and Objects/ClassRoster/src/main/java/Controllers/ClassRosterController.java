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

/**
 *
 * @author mdeha
 */
public class ClassRosterController {

    public void run() {
        ClassRosterDAO dao = new ClassRosterDAOFileImpl();
        ClassRosterView view = new ClassRosterView();
        boolean playAgain = true;

        while (playAgain) {
            view.printMenu();
            int selection = view.getSelection();
            switch (selection) {
                case 1:
                    //List all Students
                    
                    break;
                case 2:
                    //Create new Student
                    Student ns = view.getNewStudent();
                    dao.addStudent(ns.getStudentId(), ns);
                    view.createSuccess();
                    break;
                case 3:
                    //View a student
                    break;
                case 4:
                    //Remove a student
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
