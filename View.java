package project1.beach;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rbeach4
 */
public class View {

    Scanner scan;

    /**
     * gets the number of the course from the user
     * @return returns courseNum to use in other classes
     */
    public int getCourseNum() {
        scan = new Scanner(System.in);
        System.out.println("Please enter a Course Number: ");
        int courseNumber = scan.nextInt();
        return courseNumber;
    }

    /**
     * gets the department from the user
     * @return dept returns the department to use in other classes
     */
    public String getDept() {
        scan = new Scanner(System.in);
        System.out.println("Please enter a Department: ");
        String dept = scan.next();
        return dept;
    }

    /**
     * gets the semester(array index) from the user
     *
     * @return semester to uses semester(array index) in other classes
     */
    public int getSemester() {
        scan = new Scanner(System.in);
        System.out.println("Please enter a Semester: ");
        int semester = scan.nextInt();
        return semester;
    }

    /**
     * gets the course(other array index) from the user
     * @return course the courses(array index) to be used in other classes
     */
    public int getCourse() {
        scan = new Scanner(System.in);
        System.out.println("Please enter the Course: ");
        int course = scan.nextInt();
        return course;
    }

    /**
     * gets the grade from the user that they received in the course
     * @return grade the grade to be used to set the grade
     */
    public String getGrade() {
        scan = new Scanner(System.in);
        System.out.println("Please enter the grade you received for this course: ");
        String grade = scan.next();
        return grade;
    }

    /**
     * gets yes or no from user if they already have program of study available
     * @return isExsisting yes or no to use in the decision
     */
    public String getIsExsisting() {
        scan = new Scanner(System.in);
        System.out.println("Is there an exsisting Program of Study(Y or N)? ");
        String isExsisting = scan.next();
        return isExsisting;
    }

    /**
     * second part of the program if it is yes,
     * @return file1 the file that the user types in
     */
    public String getFileName() {
        scan = new Scanner(System.in);
        System.out.println("Enter the filename for the existing file: ");
        String file1 = scan.nextLine();
        return file1;
    }

    /**
     * ask the user if they want to continue
     * @return cont is yes or no
     */
    public String wantToContinue() {
        scan = new Scanner(System.in);
        System.out.println("Do you want to continue? ");
        String cont = scan.next();
        return cont;
    }

    /**
     * gets the concentration from the user
     * @return fileName is the file that the user types in
     */
    public String getConcentration() {
        scan = new Scanner(System.in);
        System.out.println("Please enter your concentration: ");
        String fileName = scan.nextLine();
        return fileName;
    }

    /**
     * displays all of the concentrations of the file name
     * @return name returns output
     */
    public String displayConcentration() {  // got from http://alvinalexander.com/blog/post/java/create-files-in-directory         
        String name = "";
        File folder = new File("H:\\ITEC 220\\Project1-Beach\\UsedFiles");
        File[] listOfFiles = folder.listFiles();
        System.out.println("(List of choices)\n");
        for (int i = 0; i < listOfFiles.length; i++) {
            switch (listOfFiles[i].getName()) {
                case "InformationSystems.dat":
                    name = "Information Systems (IS)";
                    break;
                case "WebDevelopment.dat":
                    name = "Web Development (WD)";
                    break;
                case "ComputerScience.dat":
                    name = "Computer Science (CS)";
                    break;
                case "Database.dat":
                    name = "Database (DB)";
                    break;
                case "Networks.dat":
                    name = "Networks (NW)";
                    break;
                case "SoftwareEngineering.dat":
                    name = "Software Engineering (SE)";
                    break;
            }
            if (listOfFiles[i] != null && listOfFiles[i].isFile()) {
                System.out.println(name);
            }
        }
        return name;
    }

    /**
     * gets the actual file from the folder of UsedFiles
     * @param name name of the concentration
     * @return file file named by professor
     */
    public String getFile(String name) {
        String file = "";
        if (name.equals("IS")) {
            file = "H:\\ITEC 220\\Project1-Beach\\UsedFiles\\InformationSystems.dat";
        }
        if (name.equals("WD")) {
            file = "H:\\ITEC 220\\Project1-Beach\\UsedFiles\\WebDevelopment.dat";
        }
        if (name.equals("CS")) {
            file = "H:\\ITEC 220\\Project1-Beach\\UsedFiles\\ComputerScience.dat";
        }
        if (name.equals("DB")) {
            file = "H:\\ITEC 220\\Project1-Beach\\UsedFiles\\Database.dat";
        }
        if (name.equals("NW")) {
            file = "H:\\ITEC 220\\Project1-Beach\\UsedFiles\\Networks.dat";
        }
        if (name.equals("SE")) {
            file = "H:\\ITEC 220\\Project1-Beach\\UsedFiles\\SoftwareEngineering.dat";
        }
        return file;
    }

    /**
     * gets the method from the user
     * @return the method from the user
     */
    public String getMethod() {
        String method = "";
        scan = new Scanner(System.in);
        System.out.println("Please enter one of the following: ");
        method = scan.next();
        return method;
    }

    /**
     * displays all the method for the user
     */
    public void displayMethod() {
        System.out.println("Valid entries:" + "\n" + "find \nadd \nremove \ngrade \nprereq \nprints \nprintPOS \ncheck \nsave");
    }

    /**
     * selects the method from the program of study
     * @param method is the method that want to execute
     * @param p1 access to programOfStudy class
     */
    public void executeMethods(String method, ProgramOfStudy p1) {         
        switch (method) {
            case "find":
                p1.find();
                break;
            case "add":
                p1.addCourse();
                break;
            case "remove":
                p1.removeCourse();
                break;
            case "grade":
                p1.addGrade();
                break;
            case "prereq":
                p1.addPrereq();
                break;
            case "prints":
                p1.prints();
                break;
            case "printPOS":
                p1.printPOS();
                break;
            case "check":
                p1.checkPrereqs();
                break;
            case "save":
                try {
                    p1.save(saveFileWhere());
                } catch (IOException ex) {
                    System.out.println("Error saving file!!");
                }
                break;
            default:
                System.out.println("This is a invalid command!");
                break;
        }
    }

    /**
     * gets the credit hour from the user
     * @return creditHours
     */
    public int getCreditHour() {
        scan = new Scanner(System.in);
        System.out.println("Please enter the amount of credit hours: ");
        int creditHours = scan.nextInt();
        return creditHours;
    }

    /**
     * gets the courseTitle from the user
     * @return courseTitle is the name of the course
     */
    public String getCourseTitle() {
        scan = new Scanner(System.in);
        System.out.println("Please enter the course title: ");
        String courseTitle = scan.nextLine();
        return courseTitle;
    }

    /**
     * gets file name from user
     * @return file and specifies where you want to save it
     */
    public String saveFileWhere() {
        scan = new Scanner(System.in);
        System.out.println("What do you want to name the file? ");
        String file = scan.nextLine();
        return file;
    }
}
