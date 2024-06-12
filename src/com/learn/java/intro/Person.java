package com.learn.java.intro;

public class Person {
    private String name;
    private String gender;
    private String dob;
    private byte age;
    private String maritalStatus;
    private String doorNumber;
    private String street;
    private String locality;
    private String city;
    private String country;
    private int pinCode;
    private boolean isAadharAvailable;
    private boolean isTelephoneAvailable;
    private long phoneNumber = 8610045338l;
    private String qualification;
    private boolean isSalaried;
    private int monthSalary;
    private int monthlyExpense;
    private String[] hobbies;

    public static void main(String[] args) {
        Person person = new Person();
        person.setAadharAvailable(true);
        person.setName("Manikandan");
        person.setAge((byte)18);
        person.setCity("Chennai");
        person.setCountry("India");
        person.setDob("23/11/2005");
        person.setDoorNumber("32");
        person.setGender("Male");
        person.setLocality("Chengalpet");
        person.setMaritalStatus("Unmarried");
        person.setMonthSalary(10000);
        person.setMonthlyExpense(9000);
        person.setPhoneNumber(8610045338l);
        person.setPinCode(603109);
        person.setQualification("12 Standard CBSE");
        person.setSalaried(true);
        person.setTelephoneAvailable(true);
        person.setStreet("Padasalai Street, Desimugipet, Thirukazhukundram");
        person.setHobbies(new String[]{"Badmiton", "Chess", "Carrom", "E-Sports"});
        System.out.println(person);
        System.out.println("Is Eligible to Vote: "+person.isEligibleToVote());
    }

    @Override
    public String toString(){
        return "Name: "+name+"\nAddress: "+street+"\nQualification: "+qualification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public void setAadharAvailable(boolean isAadharAvailable) {
        this.isAadharAvailable = isAadharAvailable;
    }

    public void setTelephoneAvailable(boolean isTelephoneAvailable) {
        this.isTelephoneAvailable = isTelephoneAvailable;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setSalaried(boolean isSalaried) {
        this.isSalaried = isSalaried;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    public void setMonthlyExpense(int monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public boolean isEligibleToVote(){
        if(age>=18){
            return true;
        }
        return false;
    }

    
}
