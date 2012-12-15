import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Laboration 1B
 * @author Sebastian Eriksson
 *
 */
public class Lab1B {
	
	/**
	 * Parse commandline arguments and if valid search for given element in file
	 * @param commandline arguments <element>, <filename>
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args)
			throws IOException, NumberFormatException {
		
		int element;
		String fileName;
		
		if(args.length == 2 && !args[0].isEmpty() && !args[1].isEmpty()) {
			
			// Parse string argument to integer for element
			element 	= Integer.parseInt(args[0]);
			fileName 	= args[1];
			
			// Search for element in file using helper class
			System.out.print(search(readFile(fileName), element));
			
		} else {
			throw new IOException("Invalid argument count");
		}
	}
	
	/**
	 * Search for element in sorted array using binary search
	 * @param list of objects to search
	 * @param element to search for
	 * @return true if found, otherwise false
	 */
	public static boolean search(Integer[] objects, Integer element) {
		if(objects != null)
			return (new MySortedArray<Integer>(objects)).member(element);
		
		return false;
	}
	
	/**
	 * Read from file and add to array
	 * @return array of read integers
	 * @throws FileNotFoundException
	 */
	private static Integer[] readFile(String fileName)
			throws FileNotFoundException {
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		Scanner sc = new Scanner(new File(fileName));
		
		// Read integers
		while(sc.hasNext()) {
			try {
				ints.add(sc.nextInt());
			} catch (InputMismatchException e) { sc.next(); }
		}
		
		// close 
		sc.close();
		
		return ints.toArray(new Integer[ints.size()]);
	}
}