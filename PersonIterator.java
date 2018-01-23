/**
 * 
 * @author Marta Rondan (2015280) 
 * This class will Iterate the DLList, so we can get the current position.
 *
 */
public class PersonIterator {


	Person currentPerson;
	Person previousPerson;
	DLList PersonIterator;

	PersonIterator(DLList PersonIterator){

		this.PersonIterator = PersonIterator;
		previousPerson = PersonIterator.lastLink;
		currentPerson = PersonIterator.firstLink;
	}

	public boolean hasNext(){

		if(currentPerson.next != null){

			return true;
		}

		return false;
	}

	public Person next(){

		if(hasNext()){

			previousPerson = currentPerson;
			currentPerson = currentPerson.next;
			return currentPerson;
		}

		return null;
	}

}
