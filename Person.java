/**
 * 
 * @author Marta Rondan (2015280) 
 * This class is the Person object class, which will hold its description and behavior.
 *
 */
public class Person {

	public String firstName;
	public String lastName;
	public String dateOfArrival;
	public String passport;
	public Person previous;
	public Person next;
	static public int counter = 1;
	public int id;
	

/*
 * this is the object constructor
 */
	public Person(String firstName, String lastName, String dateOfArrival, String passport) {
		
		this.id = counter;
		counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfArrival = dateOfArrival;
		this.passport = passport;
		
	}
	/**
	 * Setters and getters
	 */
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfArrival() {
		return dateOfArrival;
	}
	public void setDateOfArrival(String dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public int getId() {
		return id;
	}
	public Person getPrevious() {
		return previous;
	}
	public void setPrevious(Person previous) {
		this.previous = previous;
	}
	public Person getNext() {
		return next;
	}
	public void setNext(Person next) {
		this.next = next;
	}

/**
 * What will be displayed when the method is called.
 */
	public void display(){

		System.out.println("ID: " + id);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Date of Arrival: " + dateOfArrival);
		System.out.println("Passport Number: " + passport);
	}
/**
 * Used in this project to show who is the next person in the queue.
 */
	public String toString(){
		return "[First Name = " + firstName + ", Last Name = " + lastName + ", id: " + id +"]";
	}
}




