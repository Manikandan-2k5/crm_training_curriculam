package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>Class for Manipulating Student Marks</p>
 */
public class StudentMarksCalculation {

    byte noOfSubjects = 0;
    short[] markArray = null;
    short markPerSubject = 0;

    public static void main(String[] args) {
        StudentMarksCalculation marksCalculation = new StudentMarksCalculation();
        // marksCalculation.setNoOfSubjects();
        // marksCalculation.setMarkPerSubject();
        // marksCalculation.setMarks();
        // System.out.println("Your Average: "+marksCalculation.average());
        // System.out.println("Your Total: "+marksCalculation.totalMarks());
        // System.out.println("Your Percentage: "+marksCalculation.percentage());
        // marksCalculation.isEligibleForNextGrade();
        marksCalculation.isEligibleForMBBS();
    }
    
    /**
     * <p>Returns the sum of marks of all the subject</p>
     * @return returns the total marks
     */
    public double totalMarks(){
    	short total = 0;
    	for(int mark: markArray){
    		total+=mark;
    	}
    	return total;
    } 
    
    /**
     * <p>Returns the average of marks of all the subject</p>
     * @return returns the average mark
     */
    public double average(){
    	double total = totalMarks();
    	double average = total/noOfSubjects;
    	return average;
    }
    
    /**
     * <p>Returns the percentage of the total marks</p>
     * @return returns the percentage
     */
    public double percentage(){
    	double total = totalMarks();
    	short totalMarks = (short) (noOfSubjects*markPerSubject);
    	return (total/totalMarks)*100;
    }

    public void setNoOfSubjects(){
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	try{
    		System.out.print("Enter No of Subjects: ");
    		noOfSubjects = (byte) Integer.parseInt(reader.readLine());
    		System.out.println(); 
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public void setMarkPerSubject(){
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	try{
    		System.out.print("Enter Mark per Subject: ");
    		markPerSubject = (short) Integer.parseInt(reader.readLine()); 
    		System.out.println();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public void setMarks(){
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	markArray = new short[noOfSubjects];
    	for(int i=0; i<noOfSubjects; i++){
    		System.out.print("Enter mark for Subject "+(i+1)+" :");
    		try {
    			markArray[i] = (short)Integer.parseInt(reader.readLine());
    			System.out.println();
    		} 
    		catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    
    /**
     * <p>Prints whether the person having this total mark is eligible for next grade</p>
     */
    public void isEligibleForNextGrade(){
    	if(percentage()<50){
    		System.out.println("You are not eligible for next grade.");
    	}
    	else{
    		System.out.println("You are eligible for next grade.");
    	}
    }

    /**
     * <p>Prints whether the person having this total mark is eligible for MBBS</p>
     */
    public void isEligibleForMBBS(){
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	byte category;
    	short totalMarks;
    	short cutOff;
    	try{
    		System.out.println("Categories\n");
    		System.out.println("1. General");
    		System.out.println("2. General-Pwd");
    		System.out.println("3. SC/ST/OBC");
    		System.out.println("4. SC/ST/OBC-Pwd\n");
    		System.out.print("Enter your Option: ");
    		category = (byte) Integer.parseInt(reader.readLine()); 
    		System.out.print("\nEnter your Score in Neet: ");
    		totalMarks = (short) Integer.parseInt(reader.readLine());
    		System.out.println(); 
    		if(category==1){
    			cutOff = 137;
    		}
    		else if(category==2){
    			cutOff = 121;
    		}
    		else if(category==3){
    			cutOff = 107;
    		}
    		else if(category==4){
    			cutOff = 107;
    		}
    		else{
    			System.out.println("Wrong Category.");
    			return;
    		}
    		if(totalMarks<cutOff){
    			System.out.println("You are not Eligible for MBBS counselling.");
    		}
    		else{
    			System.out.println("You are Eligible for MBBS counselling.");
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
