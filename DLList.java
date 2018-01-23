import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.Current;

/**
 * 
 * @author Marta Rondan (2015280)
 * This class creates a Doubly Linked List, instantiate the object person. 
 * The objects from Person comes as firstLink, lastLink and their position is given through references, 
 * previous and next.
 * The Person p is used to edit the object.
 */

public class DLList {

	Person firstLink;    
	Person lastLink;
	Person next;
	Person previous;
	Person p;



	/**
	 * 	This method add a new link in at the start of the queue (head). In this project this represents the person with 
	 * children with the age under or equal 1.
	 * @param firstName - First Name of the person
	 * @param lastName - Last Name of the person
	 * @param dateOfArrival - When the person arrived in the country
	 * @param passport - The number of the document.
	 * @param id - a key that will work to find the person by id.
	 */




	public void insertHead(String firstName,String lastName,String dateOfArrival,String passport){

		Person newLink = new Person(firstName, lastName, dateOfArrival, passport);


		if(isEmpty()){

			lastLink = newLink;              // if the list is empty, the new link is in the last position in the list.

		} else {

			firstLink.previous = newLink;    //this will put the new link before the first 

		}

		newLink.next = firstLink;
		firstLink = newLink;

	}
	/**
	 * 
	 * @return next, the next person list
	 */
	public Person getNext() {
		return next;
	}

	/**
	 * @return the previous person in the link 
	 */

	public Person getPrevious(){
		return previous;
	}

	/**
	 * This method insert a new link in the end of the list and after this link, the next has to be null.
	 */
	public void insertTail(String firstName,String lastName,String dateOfArrival,String passport){

		Person newLink = new Person(firstName, lastName, dateOfArrival, passport);

		if(isEmpty()){

			firstLink = newLink;

		}else{

			lastLink.next = newLink;
			newLink.previous = lastLink;

		}

		lastLink = newLink;

	}
	/**
	 * 
	 * @return if the list is null
	 */
	public boolean isEmpty(){

		return(firstLink == null);

	}

	Integer id = 0;

	/**
	 * 
	 * @param id, the id comes from menu, which is the main class.
	 * The method gets the object by its ID
	 */
	public void getPersonById(int id) {

		this.id = id;
		Person current = firstLink;
		boolean found = true;

		do{

			if (current.getId() == id){

				current.display();
				System.out.println("Position: "+ Person.counter++);;
				System.out.println("\n");
				System.out.println("Next Person:" + current.next);
				current = current.next;

				System.out.println();

				found = false;

			}else{
				current = current.next;
			}
		}
		while(found); 
	}

	/**
	 * 
	 * This method inserts a link after a specific link, for kids older than 1 year old. 
	 * 
	 * @param key - This parameter compares with the @param id 
	 * @return
	 */

	public boolean insertAfterKey(String firstName,String lastName,String dateOfArrival,String passport, int key){

		Person newLink = new Person(firstName, lastName, dateOfArrival, passport);
		Person currentPerson = firstLink;


		while(currentPerson.id != key){ 
			currentPerson = currentPerson.next;

			if(currentPerson == null){

				return false;
			}
		}

		if(currentPerson == lastLink){
			newLink.next = null;
			lastLink = newLink;

		}else{

			newLink.next = currentPerson.next;
			currentPerson.next.previous = newLink;
		}

		newLink.previous = currentPerson;
		currentPerson.next = newLink;
		return true;

	}
	public void editById(int id, String firstName,String lastName,String dateOfArrival,String passport){
		

		this.id = id;
		Person current = firstLink;
		boolean found = true;

		do{

			if (current.getId() == id){

					current.setFirstName(firstName);
					current.setLastName(lastName);
					current.setDateOfArrival(dateOfArrival);
					current.setPassport(passport);

				found = false;

			}else{
				current = current.next;
			}
		}
		while(found); 
	}

	/**
	 * This method removed the objects by id. 
	 * @param id this id is the Persons id and it's used to identify the object position and 
	 * remove it.
	 */
	public void removeById(int id){


		this.id = id;
		Person current = firstLink;
		Person last = lastLink;
		boolean found = true;

		do{

			if (current.getId() == id){ // check if the id coming from the string  buffered reader is the same as the id to be removed

				if(current.next != null && current.previous!= null){ // if the numbers are not the head or tail
					current = current.next;
					current.previous.previous.next = current;


				}else if(current.next == null){ // if the number is tail

					current = current.previous;
					current.next = null;


				}else if(current.previous == null){ // if the number is head
					firstLink = current.next;

				}
				found = false; // when finds, the flag change and stop the loop

			}else{
				current = current.next;
			}
		}
		while(found); 
	}
	/**
	 * This method removes n objects from the back of the list
	 * 
	 * @param num comes from the buffered reader in the menu which the user picks the number of nodes
	 * he wants to remove from the back of the list.
	 */

	public void removeFromBack(int num){


		Person current = lastLink;
		boolean found = true;
		int i = 0;

		do{
			if(isEmpty()){
				System.out.println("List is Empty"); // if the list is empty will print the message

			}else{

				while (i < num && !isEmpty())  { // while the the counter is less then the number opted, the object will be the previous one.
					lastLink.next = null;
					current = current.previous;
					current.next = null;
					i++;	
					found= false;
				}
				current = current.previous;
			}
		}
		while(found);
	}

	/**
	 * This method print out the Linked List in order of people and the next link and position
	 */

	public void display(){

		Person link = firstLink;
		Person.counter = 1;

		while(link != null){

			link.display();
			System.out.println("Position: "+ Person.counter++);;
			System.out.println("\n");
			System.out.println("Next Person:" + link.next);
			link = link.next;

			System.out.println();
		}

	}

}






