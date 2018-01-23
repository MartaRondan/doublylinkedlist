import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Marta Rondan (2015280) 
 * This class is the main class. It's the command line menu and its methods.
 *
 */
public class Menu {

	Scanner scanner;
	Person person;
	DLList ddlist;
	DLList dll = new DLList();
	
	

	public static void main(String[] args) {

		new Menu();

	}

/**
 * This method 'starts' the program calling the method ListOfPeople, which instantiate some 
 * objects so the list is already running to make it easy to understand the project and also 
 * work around with the methods.
 */
	public Menu(){

		ListOfPeople();

		try {

			menuOptions();

		} catch (IOException e) {

			e.printStackTrace();
		}


	}

/**
 * This list give names to the objects and make it easier to work with the program and
 * see how it works.
 * Attention goes to the last one that is inserted, Madonna, and she is in the top of the 
 * list, as she is inserted as a head. This method is for the child with less than 1 year old.
 */
	private void ListOfPeople() {

		dll.insertTail("Michael", "Jackson", "10/01/1968", "KJI8737");
		dll.insertTail("Patsy", "Cline", "01/02/1970", "IJ90837");	
		dll.insertTail("Frank", "Sinatra", "01/07/1979", "I0837");	
		dll.insertTail("Daniel", "Looley", "01/02/1970", "IJ90837");	
		dll.insertTail("Elvis", "Presley", "20/11/1950", "FE63537");
		dll.insertTail("Elis", "Regina", "01/07/1945", "I0837");	
		dll.insertHead("Madonna", "Singer", "01/07/1993", "I0837");	
	}

/**
 * This class gives the user options to chose from.
 * @throws IOException
 */

	private void menuOptions() throws IOException {

		System.out.println("***Immigration Office System***");
		System.out.println("\n");
		System.out.println("Please choose a valid option fom the menu: ");
		System.out.println("A. Add new person to the system");
		System.out.println("B. Check a person by id");
		System.out.println("C. Remove a person by ID");
		System.out.println("D. Check List");
		System.out.println("E. Current Person");
		System.out.println("F. Insert After an Id");
		System.out.println("G. Delete n people from back");
		System.out.println("H. Edit Person");


		String helper = scannerHelper("");

		if(helper.equals("A")){

			personAndChild();
		}

		if(helper.equals("C")){
			removePerson();
		}

		if(helper.equals("D")){
            checkList();
		}
		if(helper.equals("B")){
			getPerson();
		}
		if(helper.equals("E")){
			currentPerson();
		}
		if(helper.equals("F")){
			insertAfterId();
		}
		if(helper.equals("G")){
			deleteNPeople();
		}
		if(helper.equals("H")){
			editObject();
		}
	}
	private void checkList() throws IOException {
		dll.display();
		menuOptions();
	}

/**
 * This method calls the editObject from the DLList, where you can edit a person in the 
 * queue and hold its position at the same time.
 * @throws IOException
 */
	private void editObject() throws IOException{
		
		int rem = 0;
		String fname;
		String lname;
		String doa;
		String pass;


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		try{
			System.out.println("");
			System.out.println("Insert id:");
			rem = Integer.valueOf(br.readLine());
			
			dll.getPersonById(rem);
			
			System.out.println("");
			System.out.println("Name: ");
			fname = br.readLine();

			System.out.println("");
			System.out.println("Last Name: ");
			lname = br.readLine();

			System.out.println("");
			System.out.println("Date Of Arrival: ");
			doa = br.readLine();

			System.out.println("");
			System.out.println("Passport: ");
			pass = br.readLine();
            
			dll.editById(rem, fname,lname, doa, pass);
			dll.display();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		menuOptions();
	}

	/**
	 * This method will pass the integer number of the number of objects that should be deleted
	 * in the deleteFromTheBack method in the DLList, and also call it back to be executed.
	 * @throws IOException
	 */
	private void deleteNPeople() throws IOException{
		
		int num;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Number of people to be removed:");


		try {

			num = Integer.valueOf(br.readLine());
			dll.removeFromBack(num);
			dll.display();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		menuOptions();
	}
		
/**
 * This method asks which position the user would like to insert the object using the previous person
 * id.	
 * @throws IOException
 */
	private void insertAfterId() throws IOException {
		
		int rem;
		String fname;
		String lname;
		String doa;
		String pass;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try{

			System.out.println("");
			System.out.println("Insert After id:");
			rem = Integer.valueOf(br.readLine());

			System.out.println("");
			System.out.println("Name: ");
			fname = br.readLine();

			System.out.println("");
			System.out.println("Last Name: ");
			lname = br.readLine();

			System.out.println("");
			System.out.println("Date Of Arrival: ");
			doa = br.readLine();

			System.out.println("");
			System.out.println("Passport: ");
			pass = br.readLine();

			dll.insertAfterKey(fname, lname, doa, pass, rem);
			dll.display();

		} catch (IOException e) {
			e.printStackTrace();
		}
		menuOptions();
	}

/**
 * This method use the Iterator class to show who is the current person on the list.
 * @throws IOException
 */
	private void currentPerson() throws IOException{

		System.out.println("\n");
		System.out.println("CURRENT PERSON");
		PersonIterator peopleIterator = new PersonIterator(dll);
		peopleIterator.currentPerson.display();
		menuOptions();

	}

/**
 * This method is part of the menu method, when the user is asked if the person has a child with him/her
 * and will trigger some if statements, yes and less than one 1 year old will insert the object before
 * the first one and has a child but older than 1 year old will insert after a specific ID.
 * @throws IOException
 */
	private void personAndChild() throws IOException{

		String answ1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("");
			System.out.println("Do you have a child with you? Yes or No");

			answ1 = br.readLine();


			if(answ1.equalsIgnoreCase("Yes")){

				System.out.println("");
				System.out.println("Is your child younger than 1 year old? Yes or No");
				answ1 = br.readLine();

				if(answ1.equalsIgnoreCase("Yes")){
					addHead();
				}
				else{
					addAfterKey();
				}

				addHead();

			}else {

				addTail();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		menuOptions();
	}
/**
 * This method will pass the id that will have an object inserted after, can be a child older than 
 * 1 year old.
 * @throws IOException
 */
	private void addAfterKey() throws IOException {

		int rem;
		String fname;
		String lname;
		String doa;
		String pass;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try{

			System.out.println("");
			System.out.println("Insert After id:");
			rem = Integer.valueOf(br.readLine());

			System.out.println("");
			System.out.println("Name: ");
			fname = br.readLine();

			System.out.println("");
			System.out.println("Last Name: ");
			lname = br.readLine();

			System.out.println("");
			System.out.println("Date Of Arrival: ");
			doa = br.readLine();

			System.out.println("");
			System.out.println("Passport: ");
			pass = br.readLine();

			dll.insertAfterKey(fname, lname, doa, pass, rem);
			dll.display();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuOptions();
	}

/**
 * This method will pass the id to the method getPersonById from DLList and will 
 * display the person correspondent to the id inserted by the user.
 * @throws IOException
 */
	private void getPerson() throws IOException{

		int p;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Type id:");


		try {

			p = Integer.valueOf(br.readLine());

			dll.getPersonById(p);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuOptions();
	}

/**
 * This method pass the id to the method removeByID from the DLList and will remove a object using 
 * its id. 
 * @throws IOException
 */
	private void removePerson() throws IOException {

		int rem;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Remove id:");


		try {

			rem = Integer.valueOf(br.readLine());
			dll.removeById(rem);
			dll.display();

		} catch (IOException e) {
			e.printStackTrace();
		}
		menuOptions();

	}


/**
 * Calls the method insertTail in the DLList. Non-preferential people will be inserted using this method.
 * @throws IOException
 */
	private void addTail() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String fname;
		String lname;
		String doa;
		String pass;


		try{

			System.out.println("");
			System.out.println("Name: ");
			fname = br.readLine();


			System.out.println("");
			System.out.println("Last Name: ");
			lname = br.readLine();

			System.out.println("");
			System.out.println("Date Of Arrival: ");
			doa = br.readLine();

			System.out.println("");
			System.out.println("Passport: ");
			pass = br.readLine();

			dll.insertTail(fname, lname, doa, pass);
			dll.display();


		} catch (IOException e){

		} 
		menuOptions();

	}

/**
 * This method insert and object in front of the list. In a preferential queue, the person with 
 * the child until 1 year old.
 * @throws IOException
 */
	private void addHead() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String fname;
		String lname;
		String doa;
		String pass;


		try{


			System.out.println("");
			System.out.println("Name: ");
			fname = br.readLine();

			System.out.println("");
			System.out.println("Last Name: ");
			lname = br.readLine();

			System.out.println("");
			System.out.println("Date Of Arrival: ");
			doa = br.readLine();

			System.out.println("");
			System.out.println("Passport: ");
			pass = br.readLine();

			dll.insertHead(fname, lname, doa, pass);
			dll.display();

		} catch (IOException e){

		}
		menuOptions();
	}


	/**
	 * This method is the scanner to get the values from the keyboard.
	 * @param message
	 * @return
	 */

	public String scannerHelper(String message) {

		String scan = "";
		scanner = new Scanner(System.in); //Type in

		while(scan.equals("")){
			System.out.print("\n"+message+" ");
			scan = scanner.nextLine().toUpperCase().toString();
		}
		return scan;
	}
}
