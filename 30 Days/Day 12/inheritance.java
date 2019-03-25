import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;
    private int avgScore;
    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
    public Student (String firstName, String lastName, int id, int[] testScores){
        super(firstName,lastName,id);
        this.testScores=testScores;
        this.firstName=firstName;
        this.lastName=lastName;
        this.idNumber=id;
    }

    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
    public char calculate (){
        for (int i = 0; i<testScores.length; i++){
            avgScore = avgScore + testScores[i];
        }
        avgScore = avgScore/testScores.length;
        
        if(90<=avgScore&&avgScore<=100){
            return 'O';
        }else if(80<=avgScore&&avgScore<90){
            return 'E';
        }else if(70<=avgScore&&avgScore<80){
            return 'A';
        }else if(55<=avgScore&&avgScore<70){
            return 'P';
        }else if(40<=avgScore&&avgScore<55){
            return 'D';
        }else if(0<=avgScore&&avgScore<40){
            return 'T';
        }else{
            return 'X';
        }
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}