/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.beach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Program of Study Object holds the 2D array of courses
 *
 * @author Richard H Beach
 */
public class ProgramOfStudy {

    private Course[][] myCourse;
    View view;
    private String NAME;

    /**
     * creates a Program of Study with a name if the user wanted
     *
     * @param _name is able to name it outside the class
     */
    public ProgramOfStudy(String _name) {
        myCourse = new Course[10][8];
        this.NAME = _name;
    }

    /**
     * default constructor for the Program of Study creates the object and
     * initiates the array for 10 semesters and 8 courses extra just incase the
     * user does not wanna name the program of study
     */
    public ProgramOfStudy() {
        myCourse = new Course[10][8];
        NAME = "";
    }

    /**
     * name so the NAME variable can be accessed outside the program of study
     * class
     *
     * @return NAME makes the variable NAME accessible outside of this class
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * the variable NAME can be changed outside of the class if the user chooses
     * to do so
     *
     * @param NAME string to rename the name of the program of study
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * reads the file and puts each line in one index of the Course array
     *
     * @param f1 file name to be read
     */
    public void createArray(File f1) {
        try {
            Scanner scan = new Scanner(f1);
            while (scan.hasNext()) {
                int firstIndex = scan.nextInt();
                int secondIndex = scan.nextInt();
                String dept = scan.next();
                int number = scan.nextInt();
                int credit = scan.nextInt();
                String courseTitle = scan.nextLine();
                Course c1 = new Course(dept, number, courseTitle, credit, "");
                myCourse[firstIndex][secondIndex] = c1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * finds a particular courses inside of the 2D array of courses by the
     * specified department and course number from the user.
     */
    public void find() {
        int semester = 0;
        view = new View();
        String dept = view.getDept();
        int courseNum = view.getCourseNum();
        for (int col = 0; col < myCourse.length; col++) {
            for (int row = 0; row < myCourse[col].length; row++) {
                if (myCourse[col][row] != null && myCourse[col][row].getDEPARTMENT().equals(dept) && myCourse[col][row].getNUMBER() == courseNum) {// null pointer exception
                    semester = col;
                }
            }
        }
        System.out.println();
        System.out.println("The current course you requested to find is located in the " + semester + " semester." + "\n");
    }

    /**
     * adds a new course to the 2D array by getting semester, course,
     * department, course number and the credit hour
     */
    public void addCourse() {
        view = new View();
        int firstIndex = view.getSemester();
        int secondIndex = view.getCourse();
        String dept = view.getDept();
        int number = view.getCourseNum();
        int credit = view.getCreditHour();
        String courseTitle = view.getCourseTitle();
        Course c1 = new Course(dept, number, courseTitle, credit, "");
        if (myCourse[firstIndex][secondIndex] == null) {
            myCourse[firstIndex][secondIndex] = c1;

        }
    }

    /**
     * removes the specified course that is already in the array and it is
     * removed by semester and course(indexes of the array)
     */
    public void removeCourse() {
        view = new View();
        int firstIndex = view.getSemester();
        int secondIndex = view.getCourse();
        boolean isDone = true;
        if (myCourse[firstIndex][secondIndex] != null && isDone) {
            myCourse[firstIndex][secondIndex] = null;
            isDone = false;
        }
    }

    /**
     * gets a grade earned from the user and sets it with a particular course
     */
    public void addGrade() {
        view = new View();
        int semester = view.getSemester();
        int course = view.getCourse();
        String grade = view.getGrade();
        myCourse[semester][course].setGRADE(grade);
    }

    /**
     * adds a prerequisite to the arrayList inside of the course object
     */
    public void addPrereq() {
        view = new View();
        int semester = view.getSemester();
        int course = view.getCourse();
        String dept = view.getDept();
        int courseNum = view.getCourseNum();
        for (int col = 0; col < myCourse.length; col++) {
            for (int row = 0; row < myCourse[col].length; row++) {
                if (myCourse[col][row] != null && myCourse[col][row].getDEPARTMENT().equals(dept) && myCourse[col][row].getNUMBER() == courseNum) {
                    myCourse[semester][course].addPrereq(myCourse[col][row]);
                    System.out.println("Prereq has been added!");
                    System.out.println();
                }
            }
        }
    }

    /**
     * prints the current semester at a specified index
     */
    public void prints() {
        view = new View();
        int semester = view.getSemester();
        String sem = "";
        for (int row = 0; row < myCourse[semester].length; row++) {
            if (myCourse[semester][row] != null) {
                sem += myCourse[semester][row] + "\n";
            }
        }
        System.out.println(sem);
    }

    /**
     * prints the entire program of study using the toString method at the
     * bottom of this class
     */
    public void printPOS() {
        System.out.println(this.toString());
    }
    
        private int getIndexforSemester(Course c1) {
            int semester = 0;
            String dept = c1.getDEPARTMENT();
            int courseNum = c1.getNUMBER();
            for (int col = 0; col < myCourse.length; col++) {
                for (int row = 0; row < myCourse[col].length; row++) {
                    if (myCourse[col][row] != null && myCourse[col][row].getDEPARTMENT().equals(dept) && myCourse[col][row].getNUMBER() == courseNum) {
                        semester = col;
                    }
                }
            }
            return semester;
        }

    /**
     * comparing current semester(col) to the prereq's index (Course prereq) and
     * if it is less than of equal to the prereq's semester GO OVER WITH JOEY
     */
    public void checkPrereqs() {
        boolean isGood = true;
        for (int col = 0; col < myCourse.length; col++) {
            for (int row = 0; row < myCourse[col].length; row++) {
                if (myCourse[col][row] != null) {
                    for (int i = 0; i < myCourse[col][row].getPrereq().size(); i++) {
                        Course prereq = myCourse[col][row].getPrereq().get(i);
                        int semester = getIndexforSemester(prereq);
                        if (col <= semester) {
                            isGood = false;
                            System.out.println("You need this Prereq: " + prereq);
                        }
                    }
                }
            }
        }
        if (isGood) {
            System.out.println("All Prereqs are up to date.");
        }
    }

    /**
     * saves the file
     * @param fileName takes in the file it wants to save
     * @throws IOException incase the file could not save
     */
    public void save(String fileName) throws IOException {
        PrintWriter out = new PrintWriter(fileName);
        out.println(this);
        out.close();
    }

    /**
     * default toString to print all courses in the POS
     * @return result returns the entire string that is being concatenated
     */
    public String toString() {
        String result = "";
        for (int col = 0; col < myCourse.length; col++) {
            for (int row = 0; row < myCourse[col].length; row++) {
                if (myCourse[col][row] != null) {
                    result += (col + " " + row + " " + myCourse[col][row] + "\n");
                }
            }
        }
        return result;
    }
}
