package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VotersIdentification {

    int maleCandidatesEligible = 0;
    int femaleCandidatesEligible = 0;
    int maleCandidatesVisited = 0;
    int femaleCandidatesVisited = 0;

    public static void main(String[] args) {
        VotersIdentification votersApp = new VotersIdentification();
        votersApp.main();
        System.out.println("No of Candidates Visited\n");
        System.out.println("Total: "+(votersApp.maleCandidatesVisited+votersApp.femaleCandidatesVisited));
        System.out.println("Male Candidates: "+votersApp.maleCandidatesVisited);
        System.out.println("Female Candidates: "+votersApp.femaleCandidatesVisited+"\n");
        System.out.println("No of Candidates Eligible to Vote\n");
        System.out.println("Total: "+(votersApp.maleCandidatesEligible+votersApp.femaleCandidatesEligible));
        System.out.println("Male Candidates: "+votersApp.maleCandidatesEligible);
        System.out.println("Female Candidates: "+votersApp.femaleCandidatesEligible+"\n");
    }

    public ArrayList<Object> getInputs(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Object> candidateDetails = new ArrayList<Object>();
        String name = "";
        byte age = 0;
        String gender = "";
        try {
            System.out.print("Candidate Name: ");
            name = reader.readLine();
            System.out.print("\nCandidate Age: ");
            age = (byte)Integer.parseInt(reader.readLine());
            System.out.print("\nCandidate Gender: ");
            gender = reader.readLine();
            candidateDetails.add(name);
            candidateDetails.add(age);
            candidateDetails.add(gender);
        } catch (Exception e) {
            if((e.getClass().getName()).equals("NumberFormatException")){
                System.out.println("Age should be Integer type !!!");
            }
            else{
                System.out.println("Error while Processing Inputs !!!");
            }
        }
        return candidateDetails;
    }

    public boolean isEligibleVoter(byte age){
        if(age>=18){
            return true;
        }
        return false;
    }

    public void incrementMaleCandidatesVisited(){
        maleCandidatesVisited++;
    }
    public void incrementMaleCandidatesEligible(){
        maleCandidatesEligible++;
    }

    public void incrementFemaleCandidatesVisited(){
        femaleCandidatesVisited++;
    }
    public void incrementFemaleCandidatesEligible(){
        femaleCandidatesEligible++;
    }

    public void main(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            ArrayList<Object> candidate = getInputs();
            boolean isEligible = isEligibleVoter((byte)candidate.get(1));
            String gender = String.valueOf(candidate.get(2));
            if(isEligible){
                if(gender.equals("male") || gender.equals("Male") || gender.equals("MALE")){
                    incrementMaleCandidatesEligible();
                    incrementMaleCandidatesVisited();
                }
                else if(gender.equals("female") || gender.equals("Female") || gender.equals("FEMALE")){
                    incrementFemaleCandidatesEligible();
                    incrementFemaleCandidatesVisited();
                }
                else{
                    System.out.println("Give appropriate Gender !!!\n");
                    continue;
                }
                System.out.println("\n"+String.valueOf(candidate.get(0))+" is Eligible to Vote.");
            }
            else{
                if(gender.equals("male") || gender.equals("Male") || gender.equals("MALE")){
                    incrementMaleCandidatesVisited();
                }
                else if(gender.equals("female") || gender.equals("Female") || gender.equals("FEMALE")){
                    incrementFemaleCandidatesVisited();
                }
                else{
                    System.out.println("Give appropriate Gender !!!\n");
                    continue;
                }
                System.out.println("\n"+String.valueOf(candidate.get(0))+" is not Eligible to Vote.");
            }
            System.out.print("\nContinue Candidates Verification ?(y/n): ");
            try {
                char userChoice = (char)reader.read();
                reader.readLine();
                System.out.println();
                if(userChoice=='y' || userChoice=='Y'){
                    continue;
                }
                break;
            } 
            catch (Exception e) {
                System.out.println("Problem in server.");
            }
        }
    }
        

}
