package project1.beach;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Richard H Beach
 */
public class Controller {

    ProgramOfStudy p1;
    View view;

    /**
     * involves the game loop and brings model(Program of Study and Course) and view together
     */
    public void start() {
        String method;
        boolean isContinuing = false;
        view = new View();
        p1 = new ProgramOfStudy();
        boolean isDone = false;
        String fileName = "";
        String YorN = view.getIsExsisting();
        while (!(isDone)) {
            if (YorN.equals("Y")) {
                if (!(isContinuing)) {
                    fileName = view.getFileName();
                    p1.setNAME(fileName);
                    p1.createArray(new File(fileName));
                }
                p1.printPOS();
                view.displayMethod();
                method = view.getMethod();
                view.executeMethods(method, p1);

            } else {
                if (!(isContinuing)) {
                    System.out.println();
                    view.displayConcentration();
                    String name = view.getConcentration();
                    String f2 = view.getFile(name);
                    p1.createArray(new File(f2));
                    System.out.println();
                    p1.printPOS();
                }
                view.displayMethod();
                method = view.getMethod();
                view.executeMethods(method, p1);
                p1.printPOS();
            }
            if (view.wantToContinue().equals("N")) {
                isDone = true;
            } else {
                isContinuing = true;
            }

        }
    }
}
