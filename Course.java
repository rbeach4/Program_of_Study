package project1.beach;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * creates a course object
 * @author Richard H Beach
 */
public class Course {

    private String DEPARTMENT;
    private int NUMBER;
    private String NAME;
    private ArrayList<Course> prereqs;
    private int CREDIT_HOURS;
    private String GRADE;

    /**
     * creates a course
     * @param _dept represents dept
     * @param _number represents course Number
     * @param _name represents name of course
     * @param _creditHours number of credit hours
     * @param _grade grade received in course
     */
    public Course(String _dept, int _number, String _name, int _creditHours, String _grade) {
        this.DEPARTMENT = _dept;
        this.NUMBER = _number;
        this.NAME = _name;
        prereqs = new ArrayList<Course>();
        this.CREDIT_HOURS = _creditHours;
        this.GRADE = _grade;
    }

    /**
     * gets department
     * @return the dept
     */
    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    /**
     * sets department
     * @param DEPARTMENT sets the variable to input from user
     */
    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    /**
     * gets number
     * @return NUMBER of the course
     */
    public int getNUMBER() {
        return NUMBER;
    }

    /**
     *
     * @param NUMBER
     */
    public void setNUMBER(int NUMBER) {
        this.NUMBER = NUMBER;
    }

    /**
     *
     * @return
     */
    public String getNAME() {
        return NAME;
    }

    /**
     *
     * @param NAME
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     *
     * @return
     */
    public int getCREDIT_HOURS() {
        return CREDIT_HOURS;
    }

    /**
     *
     * @param CREDIT_HOURS
     */
    public void setCREDIT_HOURS(int CREDIT_HOURS) {
        this.CREDIT_HOURS = CREDIT_HOURS;
    }

    /**
     *
     * @return
     */
    public String getGRADE() {
        return GRADE;
    }

    /**
     *
     * @param GRADE
     */
    public void setGRADE(String GRADE) {
        this.GRADE = GRADE;
    }

    /**
     * adds a course to the arrayList & used in program of study
     * @param c1 is the course being added
     */
    public void addPrereq(Course c1) {
        prereqs.add(c1);
    }

    /**
     * gets the entire array list
     * @return prereqs is the entire array list accessible
     */
    public ArrayList<Course> getPrereq() {
        return prereqs;
    }

    /**
     * prints whole list of prereqs TEST METHOD
     */
    public void printList() {
        System.out.println(prereqs);
    }

    /**
     * used to test
     * @param c1
     * @return boolean of true or false
     */
    public int compareTo(Course c1) {
        return (this.CREDIT_HOURS - c1.getCREDIT_HOURS());
    }

    /**
     * another equals method to override one in the string class
     * @param s string to be taken in
     * @return j is the string i want to use
     */
    public String equals(String s) {
        String j = "";
        if (s.equals(DEPARTMENT)) {
            j += DEPARTMENT;
        }
        return j;
    }

    /**
     * make sure 2 courses are equal
     * @param c1 course to compare with one in class
     * @return true if it is equal and false if not
     */
    public boolean equals(Course c1) {
        return (this.DEPARTMENT.equals(c1.getDEPARTMENT()) && this.NUMBER == c1.getNUMBER() && this.NAME.equals(c1.getNAME()) && this.CREDIT_HOURS == c1.getCREDIT_HOURS() && this.GRADE.equals(c1.getGRADE()));
    }

    public String toString() {
        return (this.DEPARTMENT + " " + this.NUMBER + " " + this.CREDIT_HOURS + " " + this.NAME + this.GRADE);
    }
}
