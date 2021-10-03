/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.Student;
import java.util.List;

/**
 *
 * @author mdeha
 */
public class ClassRosterView {
    //Create instance of IO
    
    UserIO io;
    
    public ClassRosterView(UserIO io){
        this.io = io;
    }

    public ClassRosterView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void printMenu(){
        io.print("Please select one of the following (1-5): ");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");
    }
    public int getSelection(){
        return io.readInt("Enter an integer 1-5", 1, 5);
    }
    public void exitMsg(){
        io.print("Thank you! GoodBye!");
    }
    public Student getNewStudent(){
        String studentId = io.readString("Please enter Student Id: ");
        String firstName = io.readString("Please enter first name: ");
        String lastName = io.readString("Please enter last name: ");
        String cohort = io.readString("Please enter Cohort: ");
        
        Student ns = new Student(studentId);
        ns.setCohort(cohort);
        ns.setFname(firstName);
        ns.setLname(lastName);
        
        return ns;
    }
    
    public void createSuccess(){
        io.print("Student successfully created.");
    }
    
    public void displayStudentList(List<Student> studentIds){
        for(Student i : studentIds){
            String studentInfo = String.format("#%s : %s %s", 
                    i.getStudentId(),
                    i.getFname(),
                    i.getLname());
            io.print(studentInfo);
        }
    }
    public String getStudentId(){
        return io.readString("Please enter the student id");
    }
    public void printStudent(Student student){
        io.print("ID# "+ student.getStudentId() + "\nName: "+ student.getFname() + " " + student.getLname() + "\nCohort: "+ student.getCohort());
    }
    
    public void displayRemoveStudent(Student studentRecord){
        if(studentRecord == null){
            io.print("No Student with that id exists.");
        }
        else{
            io.print("Student removed successfully");
        }
    }
}
