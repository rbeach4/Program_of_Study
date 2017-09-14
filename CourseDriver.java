/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.beach;

/**
 *
 * obtained help from Joey Burt && Ben Humphries
 * @author Richard H Beach
 */
public class CourseDriver {

    /**
     * calls the start method from the Controller class to start the game loop
     * for execution of the programs purpose.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller c1 = new Controller();
        c1.start();
    }
}
