/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery;

import com.mycompany.flooringmastery.Controllers.FlooringMasteryController;
import java.io.FileNotFoundException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author mdeha
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.mycompany.flooringmastery");
        appContext.refresh();
        FlooringMasteryController controller = appContext.getBean("flooringMasteryController", FlooringMasteryController.class);
        controller.run();
    }
    
}
