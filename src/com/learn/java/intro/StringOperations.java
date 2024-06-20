package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>This class contains programs for string manipulations</p>
 */
public class StringOperations {
    public static void main(String[] args) {
        StringOperations stringOperations = new StringOperations();
        // stringOperations.titleCase("Hello World");
        // stringOperations.upperCase("Hello World");
        // stringOperations.lowerCase("Hello World");
        // stringOperations.sentenceCase("hello World. im Manikandan. Im in chennai.");
        // System.out.println(stringOperations.reverseString("manikandan"));
        // stringOperations.program1();
        // stringOperations.program2();
        // stringOperations.program3();
        // System.out.println(stringOperations.replace("Hello", 'e', 'o'));
        // System.out.println("Is Palindrome: "+stringOperations.isPalindrome("manikandan"));
        // System.out.println("Is Equal: "+stringOperations.equals("manikandan", "Manikandan"));
        // System.out.println(stringOperations.reverseSentence("Hi Im Manikandan"));
        // System.out.println(stringOperations.sort("Manikandan"));
        // System.out.println(stringOperations.countVowels("Manikandan"));
        // System.out.println(stringOperations.countSpecialCharacter("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~abcd"));
        // System.out.println(stringOperations.countWords("Hello Im Manikandan. Im studying in Chennai. Im 18 years old."));
        // System.out.println(stringOperations.countNumbers("2024 is an amazing year. Hello Im Manikandan. Im studying in Chennai. Im 18 years old. Im in 2024"));
        // String string = "Hello All\n     Im in chennai\n       \nIm Manikandan";
        // System.out.println(stringOperations.countLines(string));
    }

    
    /**
     * <p>Gets String Input from User</p>
     * @return
     */
    public String getInput(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

    
    /**
     * <p>Gets character Input from User</p>
     * @return
     */
    public char getSingleCharacterInput(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        char character;
        while(true){
            try {
                inputString = reader.readLine();
                if(inputString.length()>1){
                    System.out.println("Enter single character !!!");
                    System.out.print(">>");
                    continue;
                }
                else{
                    character = inputString.charAt(0);
                    break;
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return character;
    }

    
    /**
     * <p>Converts string to title case</p>
     * @param input string to be converted
     */
    public void titleCase(String input){
        String output = "";
        for(int i=0; i<input.length(); i++){
            if(i==0){
                if(isUpperCase(input.charAt(i))){
                    output+=input.charAt(i);
                }
                else{
                    output+=(char)(((int)input.charAt(i))-32);
                }
            }
            else if(input.charAt(i-1)==' '){
                if(isUpperCase(input.charAt(i))){
                    output+=input.charAt(i);
                }
                else{
                    output+=(char)(((int)input.charAt(i))-32);
                }
            }
            else{
                output+=input.charAt(i);
            }
        }
        System.out.println(output);
    }

    /**
     * <p>Converts string to lower case</p>
     * @param input string to be converted.
     */
    public void lowerCase(String input){
        String output = "";
        for(int i=0; i<input.length(); i++){
            if(isUpperCase(input.charAt(i))){
                output+=(char)(((int)input.charAt(i))+32);
            }
            else{
                output+=input.charAt(i);
            }
        }
        System.out.println(output);
    }

    /**
     * <p>Converts string to upper case</p>
     * @param input string to be converted
     */
    public void upperCase(String input){
        String output = "";
        for(int i=0; i<input.length(); i++){
            if(isLowerCase(input.charAt(i))){
                output+=(char)(((int)input.charAt(i))-32);
            }
            else{
                output+=input.charAt(i);
            }
        }
        System.out.println(output);
    } 
    
    
    /**
     * <p>Converts string to sentence case</p>
     * @param input string to be converted
     */
    public void sentenceCase(String input){
        String output = "";
        for(int i=0; i<input.length(); i++){
            if(i==0){
                if((int)input.charAt(i)>=65 && (int)input.charAt(i)<=90){
                    output+=input.charAt(i);
                }
                else if((int)input.charAt(i)>=97 && (int)input.charAt(i)<=122){
                    output+=(char)(((int)input.charAt(i))-32);
                }
                else{
                    output+=input.charAt(i);
                }
            }
            else if(((int)input.charAt(i)>=97 && (int)input.charAt(i)<=122 && i>=2) && (((int)input.charAt(i-2)==46 && (int)input.charAt(i-1)==32))){
                output+=(char)(((int)input.charAt(i))-32);
            }
            else{
                output+=input.charAt(i);
            }
        }
        System.out.println(output);
    }

    
    /**
     * <p>Checks whether a given character is upper case</p>
     * @param character character to be checked
     * @return returns true if the character is upper case, else returns false.
     */
    public boolean isUpperCase(char character){
        if((int)character>=65 && (int)character<=90){
            return true;
        }
        return false;
    }

    /**
     * <p>Checks whether a given character is lower case</p>
     * @param character character to be checked
     * @return returns true if the character is lower case, else returns false.
     */
    public boolean isLowerCase(char character){
        if((int)character>=97 && (int)character<=122){
            return true;
        }
        return false;
    }

    /**
     * <p>Returns the reverse of the given string</p>
     * @param input string to be reversed.
     * @return returns the reverse of the given string
     */
    public String reverseString(String input){
        String reverse = "";
        for(int i=input.length()-1; i>=0; i--){
            reverse+=input.charAt(i);
        }
        return reverse;
    }

    /**
     * <p>Returns the index of the character's first occurrence in the given string</p>
     * @param input string to be iterated.
     * @param character character's index to be found.
     * @return returns the index of the character's first occurrence in the given string.
     */
    public int firstPosition(String input, char character){
        int index = -1;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)==character){
                index = i;
                break;
            }
        }
        return index;
    }

    public void program1(){
        System.out.print("Enter String Input: ");
        String input = getInput();
        System.out.print("Enter Character Input to find its position in the String Input: ");
        char charInput = getSingleCharacterInput();
        int index = firstPosition(input, charInput);
        System.out.println("Position of the character is: "+index);
    }

    public void program2(){
        System.out.print("Enter String Input: ");
        String input = getInput();
        System.out.print("Enter Substring: ");
        String subString = getInput();
        boolean isSubString = isSubString(input, subString);
        System.out.println("Is the substring preset in the main string: "+isSubString);
    }

    /**
     * <p>Checks whether the given string is a substring of the other given string</p>
     * @param string given string
     * @param subString given substring
     * @return returns true if the string contains the substring, else returns false.
     */
    public boolean isSubString(String string, String subString){
        boolean result = false;
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i)==subString.charAt(0)){
                int index = 0;
                for(int j=i; j<string.length(); j++){
                    if(index>=subString.length()){
                        break;
                    }
                    else if(string.charAt(j)==subString.charAt(index)){
                        index++;
                        continue;
                    }
                    else{
                        break;
                    }
                }
                if(index==subString.length()){
                    result=true;
                    break;
                }
            }
        }
        return result;
    }

    public void program3(){
        System.out.print("Enter String Input: ");
        String input = getInput();
        System.out.print("Enter Character Input to find its position in the String Input: ");
        char charInput = getSingleCharacterInput();
        System.out.print("Enter Starting Position: ");
        int position = getNumberInput();
        int index = firstPosition(input, charInput, position);
        System.out.println("Position of the character is: "+index);
    }

    
    /**
     * <p>Gets Number input from the user and returns it</p>
     * @return returns the number input
     */
    private int getNumberInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int index = -1;
        while(true){
            try {
                input = reader.readLine();
                index = Integer.parseInt(input);
                break;
            } 
            catch (Exception e) {
                System.out.println("Wrong Numer Format !!!");
                System.out.print(">>");
                continue;
            }
        }
        return index;
    }

    /**
     * <p>Returns the first position of the character in the string starting from a particular index</p>
     * @param input String to be iterated
     * @param character character to be found
     * @param startPos start position of the string
     * @return returns the first position of the given character.
     */
    public int firstPosition(String input, char character, int startPos){
        int index = -1;
        for(int i=startPos; i<input.length(); i++){
            if(input.charAt(i)==character){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * <p>Replaces a given character in the given string at the position of the given character and returns the string.</p>
     * @param string string to be iterated
     * @param character1 character to be replaced at the position of character2
     * @param character2 character to be replaced by character1
     * @return returns the string after replacement.
     */
    public String replace(String string, char character1, char character2){
        String output = "";
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i)==character1){
                output+=character2;
            }
            else{
                output+=string.charAt(i);
            }
        }
        return output;
    }
    
    /**
     * <p>Checks whether a string is palindrome</p>
     * @param input string to be iterated
     * @return returns true if string is palindrome, else returns false.
     */
    public boolean isPalindrome(String input){
        String reverse = "";
        boolean result = false;
        if(input.charAt(0)!=input.charAt(input.length()-1)){
            return false;
        }
        for(int i=input.length()-1; i>=0; i--){
            reverse+=input.charAt(i);
        }
        int count = 0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)!=reverse.charAt(i)){
                result = false;
                break;
            }
            count++;
        }
        if(count==input.length()){
            result = true;
        }
        return result;
    }

    /**
     * <p>Checks if two strings are equal</p>
     * @param input1 string1
     * @param input2 string2
     * @return returns true if two strings are equal, else returns false.
     */
    public boolean equals(String input1, String input2){
        int count = 0;
        boolean result = false;
        if(input1.length()!=input2.length()){
            return false;
        }
        else if(input1.charAt(0)!=input2.charAt(0)){
            return false;
        }
        else if(input1.charAt(input1.length()-1)!=input2.charAt(input2.length()-1)){
            return false;
        }
        else{
            for(int i=0; i<input1.length(); i++){
                if(input1.charAt(i)!=input2.charAt(i)){
                    result = false;
                    break;
                }
                count++;
            }
            if(count==input1.length()){
                result = true;
            }
        }
        return result;
    }

    /**
     * <p>Returns reversed sentence</p>
     * @param sentence sentence to be reversed
     * @return returns reversed sentence
     */
    public String reverseSentence(String sentence){
        String output = "";
        String word = "";
        for(int i=0; i<sentence.length(); i++){
            if(sentence.charAt(i)==' '){
                output+=reverseString(word)+" ";
                word="";
                continue;
            }
            word+=sentence.charAt(i);
            if(i==sentence.length()-1){
                output+=reverseString(word);
            }
        }
        return output;
    }

    /**
     * <p>Returns sorted string<p>
     * @param string string to be sorted
     * @return returns sorted string
     */
    public String sort(String string){
        String output = "";
        int count = 0;
        int length = string.length();
        for(int i=0; i<string.length(); i++){
            char character = string.charAt(i);
            int index = 0;
            for(int j=0; j<string.length(); j++){
                if((int)character>(int)string.charAt(j)){
                    character = string.charAt(j);
                    index = j;
                }
            }
            output+=character;
            String temp = "";
            for(int k=0; k<index; k++){
                temp+=string.charAt(k);
            }
            for(int k=index+1; k<string.length(); k++){
                temp+=string.charAt(k);
            }
            string = temp;
            i=-1;
            count++;
            if(count==length){
                break;
            }
        }
        return output;
    }

    
    /**
     * <p>Returns the count of the vowels in the given string</p>
     * @param string string to be iterated
     * @return returns the count of vowels in the given string
     */
    public int countVowels(String string){
        int[] vowelAsciis = new int[]{65, 69, 73, 79, 85, 97, 101, 105, 111, 117};
        int count = 0;
        for(int i=0; i<string.length(); i++){
            for(int j=0; j<vowelAsciis.length; j++){
                if(((char)vowelAsciis[j])==string.charAt(i)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * <p>Returns the count of the special characters in the given string</p>
     * @param string string to be iterated
     * @return returns the count of special characters in the given string
     */
    public int countSpecialCharacter(String string){
        int count = 0;
        for(int i=0; i<string.length(); i++){
            if((((int)string.charAt(i))>=32 && ((int)string.charAt(i))<=47) || (((int)string.charAt(i))>=58 && ((int)string.charAt(i))<=64) || (((int)string.charAt(i))>=91 && ((int)string.charAt(i))<=96) || (((int)string.charAt(i))>=123 && ((int)string.charAt(i))<=126)){
                count++;
            }
        }
        return count;
    }

    /**
     * <p>Returns the count of the words in the given string</p>
     * @param string string to be iterated
     * @return returns the count of words in the given string
     */
    public int countWords(String string){
        int count = 0;
        if(string.length()==0){
            return count;
        }
        else{
            for(int i=0; i<string.length(); i++){
                if((i!=0 && (string.charAt(i-1)>=48 && string.charAt(i-1)<=57)) && string.charAt(i)==' '){
                    continue;
                }
                else if(string.charAt(i)==' '){
                    count++;
                }
                else if(i==string.length()-1 && !(string.charAt(i-1)>=48 && string.charAt(i-1)<=57)){
                    count++;
                }
                else{
                    continue;
                }
            }
            return count;
        }
    }

    /**
     * <p>Returns the count of the numbers in the given string</p>
     * @param string string to be iterated
     * @return returns the count of numbers in the given string
     */
    public int countNumbers(String string){
        int count = 0;
        for(int i=0; i<string.length(); i++){
            if((string.charAt(i)>=48 && string.charAt(i)<=57)){
                count++;
                for(int j=i+1; j<string.length(); j++){
                    if((string.charAt(j)>=48 && string.charAt(j)<=57) && j==string.length()-1){
                        i = j;
                    }
                    else if((string.charAt(j)>=48 && string.charAt(j)<=57)){
                        continue;
                    }
                    else{
                        i = j;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * <p>Returns the count of the lines in the given string</p>
     * @param string string to be iterated
     * @return returns the count of lines in the given string
     */
    public int countLines(String string){
        int count = 0;
        if(string.length()==0){
            return count;
        }
        for(int i=0; i<string.length(); i++){
            if(i==string.length()-1){
                count++;
            }
            else if(string.charAt(i)==10 && i!=0){
                boolean isValidLine = false;
                for(int j=i+1; j<string.length(); j++){
                    if(string.charAt(j)==10){
                        i=j-1;
                        break;
                    }
                    else if(string.charAt(j)>=33 && string.charAt(j)<=122 && !isValidLine){
                        isValidLine = true;
                        count++;
                    }
                    else{
                        continue;
                    }
                }
            }
            else{
                continue;
            }
        }
        return count;
    }

    public void program4(String string){
    	System.out.println("No of Words in string: "+countWords(string));
    	System.out.println("No of Lines in string: "+countLines(string));
    	System.out.println("No of Numbers in string: "+countNumbers(string));
    	System.out.println("No of Special Characters in string: "+countSpecialCharacter(string));
    	System.out.println("No of Vowels in string: "+countVowels(string));
    	System.out.println("No of Characters in string: "+string.length());
    }

}
