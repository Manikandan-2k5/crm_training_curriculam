package com.learn.java.intro;

public class Enum {
	public enum Day{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	public static void main(String[] args) {
		Day day = Day.MONDAY;
		switch(day) {
			case SUNDAY :
				System.out.println(Day.SUNDAY);
				break;
			case MONDAY :
				System.out.println(Day.MONDAY);
				break;
			case TUESDAY :
				System.out.println(Day.TUESDAY);
				break;
			case WEDNESDAY :
				System.out.println(Day.WEDNESDAY);
				break;
			case THURSDAY :
				System.out.println(Day.THURSDAY);
				break;
			case FRIDAY :
				System.out.println(Day.FRIDAY);
				break;
			case SATURDAY :
				System.out.println(Day.SATURDAY);
				break;
		}
	}
}
