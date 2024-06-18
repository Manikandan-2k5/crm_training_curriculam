package com.learn.java.intro;

public class Enum {
	public enum Day{
		SUNDAY("Leave"), MONDAY("Working Day"), TUESDAY("Working Day"), WEDNESDAY("Working Day"), THURSDAY("Working Day"), FRIDAY("Working Day"), SATURDAY("Leave");
		private String dayType = "Day";
		
		private Day(String dayType){
			this.dayType = dayType;
		}
		
	}
	
	public static void main(String[] args) {
		Day day = Day.MONDAY;
		switch(day) {
			case SUNDAY :
				System.out.println(Day.SUNDAY.dayType);
				break;
			case MONDAY :
				System.out.println(Day.MONDAY.dayType);
				break;
			case TUESDAY :
				System.out.println(Day.TUESDAY.dayType);
				break;
			case WEDNESDAY :
				System.out.println(Day.WEDNESDAY.dayType);
				break;
			case THURSDAY :
				System.out.println(Day.THURSDAY.dayType);
				break;
			case FRIDAY :
				System.out.println(Day.FRIDAY.dayType);
				break;
			case SATURDAY :
				System.out.println(Day.SATURDAY.dayType);
				break;
		}
	}
}
