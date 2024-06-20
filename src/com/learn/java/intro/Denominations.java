package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * <p>This class provides program for denomination based calculations</p>
 */
public class Denominations {

    short twoThousand = 2000;
    short fiveHundred = 500;
    short hundred = 100;
    short fifty = 50;
    short ten = 10;
    short one = 1;

    public static void main(String[] args) {
        Denominations denominations = new Denominations();
    }

    /**
     * <p>Prints rupees in the available denominations</p>
     * @param rupees rupees to be converted to denominations.
     */
    public void rupeesToDenominations(int rupees){
        ArrayList<int[]> denominations = new ArrayList<int[]>();
        while(rupees>0){
            int[] denomination = new int[2];
            if(rupees>twoThousand){
                int noOfDenominations = rupees/twoThousand;
                denomination[0] = twoThousand;
                denomination[1] = noOfDenominations;
                rupees%=twoThousand;
            }
            else if(rupees>fiveHundred){
                int noOfDenominations = rupees/fiveHundred;
                denomination[0] = fiveHundred;
                denomination[1] = noOfDenominations;
                rupees%=fiveHundred;
            }
            else if(rupees>hundred){
                int noOfDenominations = rupees/hundred;
                denomination[0] = hundred;
                denomination[1] = noOfDenominations;
                rupees%=hundred;
            }
            else if(rupees>fifty){
                int noOfDenominations = rupees/fifty;
                denomination[0] = fifty;
                denomination[1] = noOfDenominations;
                rupees%=fifty;
            }
            else if(rupees>ten){
                int noOfDenominations = rupees/ten;
                denomination[0] = ten;
                denomination[1] = noOfDenominations;
                rupees%=ten;
            }
            else{
                int noOfDenominations = rupees/one;
                denomination[0] = one;
                denomination[1] = noOfDenominations;
                rupees%=one;
            }
            denominations.add(denomination);
        }
        System.out.println(denominationsToString(denominations));
        System.out.println("The amount for the fiven denominations array is: "+denominationsToRupees(denominations));
    }


    
    /**
     * <p>Returns String which represents the denominations of a rupee currency</p>
     * @param denominations
     * @return returns string representation of a rupee denomination.
     */
    public String denominationsToString(ArrayList<int[]> denominations){
        String result = "";
        int total = 0; 
        for(int[] denomination : denominations){
            result+=denomination[0]+" * "+denomination[1]+" = "+denomination[0]*denomination[1]+"\n";
            total+=denomination[0]*denomination[1];
        }
        result+="Total: "+total;
        return result;
    }

    
    /**
     * <p>Return rupees from the given denominations</p>
     * @param denominations to be converted to rupees
     * @return returns rupees of the given denominations
     */
    public int denominationsToRupees(ArrayList<int[]> denominations){
        if(denominations.size()==0){
            return 0;
        }
        else{
            int total = 0;
            for(int[] denomination : denominations){
                total+=denomination[0]*denomination[1];
            }
            return total;
        }
    }

    /**
     * <p>Creates a user interface for user to give denominations input</p>
     */
    public void inputDenominations(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> denominations = new ArrayList<int[]>();
        try{
            System.out.println("Input format should be like \"2000 = 2\" where LHS is denomination and RHS is its repitation.");
            System.out.println();
            while(true){
                System.out.println("Enter Denominations:\n");
                String denominationString = reader.readLine();
                System.out.println();
                String[] denominationStringArray = denominationString.split(" = ");
                if(denominationStringArray.length<0){
                    System.out.println("Your input format is wrong");
                    break;
                }
                int[] denomination = new int[2];
                denomination[0] = Integer.parseInt(denominationStringArray[0]);
                denomination[1] = Integer.parseInt(denominationStringArray[1]);
                denominations.add(denomination);
                System.out.print("Wanna add more ?(y/n): ");
                char userChoice = (char) reader.read();
                reader.readLine();
                if(userChoice!='y' && userChoice!='Y'){
                    break;
                }
                System.out.println();
            }
            System.out.println("Total amount for the above given denominations: "+denominationsToRupees(denominations));
        }
        catch(Exception e){
           System.out.println("Your input format is wrong");
        }
    }

}
