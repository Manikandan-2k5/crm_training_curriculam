package com.learn.java.intro;

public class RelationalOperators {

    public static void main(String[] args) {
        RelationalOperators compare = new RelationalOperators();
        // System.out.println(compare.bigNumber(4, 3));
        // System.out.println(compare.bigNumber(9,4, 9));
        compare.upperOrLower('a');
        compare.upperOrLower('b');
        compare.upperOrLower('c');
        compare.upperOrLower('d');
        compare.upperOrLower('e');
        compare.upperOrLower('f');
        compare.upperOrLower('g');
        compare.upperOrLower('x');
        compare.upperOrLower('y');
        compare.upperOrLower('z');
        compare.upperOrLower('v');
        compare.upperOrLower('A');
        compare.upperOrLower('B');
        compare.upperOrLower('C');
        compare.upperOrLower('D');
        compare.upperOrLower('U');
        compare.upperOrLower('V');
        compare.upperOrLower('W');
        compare.upperOrLower('X');
        compare.upperOrLower('Y');
        compare.upperOrLower('Z');
    }

    public int bigNumber(int a, int b){
        if(a<b){
            return b;
        }
        else{
            return a;
        }
    }

    public int bigNumber(int a, int b, int c){
        if(a>=b && a>=c){
            return a;
        }
        else if(b>=a && b>=c){
            return b;
        }
        else{
            return c;
        }
    }

    public void upperOrLower(char alphabet){
        if((int)alphabet>=65 && (int)alphabet<=90){
            System.out.println(alphabet+" is UpperCase");
        }
        else if((int)alphabet>=97 && (int)alphabet<=122){
            System.out.println(alphabet+" is LowerCase");
        }
        else{
            System.out.println(alphabet+" is Special Character");
        }
    }
}
