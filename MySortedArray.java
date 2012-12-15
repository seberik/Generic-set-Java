/**
 * Implementing a set of elements of arbitrary type by a sorted array
 * @author Sebastian Eriksson
 *
 */
public class MySortedArray<E extends Comparable<? super E>> implements MySet<E> {

	private E[] sortedArray;
	
	/**
	 * Constructor, store array
	 * @param sorted array of comparable objects
	 */
	public MySortedArray(E[] sortedArray) {
		this.sortedArray = sortedArray;
	}

	/**
	 * Search for object in array of comparable objects
	 * @param array of sorted comparable objects
	 * @param object to search for
	 * @return -1 if not found, otherwise position [0, inf)
	 */
	public static <F extends Comparable<? super F>>
	int binarySearch(F[] haystack, F needle) {
		
		int low = 0, high = haystack.length - 1;
		
		while(low <= high) {
			
			int mid = low + ((high - low)/2);
			
			if( (haystack[mid].compareTo(needle) ) > 0 )
				high = mid - 1;
			else if( (haystack[mid].compareTo(needle) ) < 0 )
				low = mid + 1;
			else
				return mid;
				
		}
		
		return -1;
	}
	
	/**
	 * Check if a element exists in set using binary search algorithm
	 * @param element to search for
	 * @return true if found otherwise false
	 */
	public boolean member(E element) {
		if(binarySearch(sortedArray, element) >= 0) {
			return true;
		}
		
		return false;
	}
}
