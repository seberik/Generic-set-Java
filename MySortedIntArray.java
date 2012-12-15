/**
 * Implementing a set of integers by a sorted array
 * @author Sebastian Eriksson
 *
 */
public class MySortedIntArray implements MyIntSet {

	private int[] sortedArray;
	
	/**
	 * Constructor, store array
	 * @param sorted array of integers
	 */
	public MySortedIntArray(int[] sortedArray) {
		this.sortedArray = sortedArray;
	}

	/**
	 * Search for integer in given sorted integer array.
	 * @param array of sorted integers
	 * @param integer to search for
	 * @return -1 if not found, otherwise position [0, inf)
	 */
	public static int binarySearch(int[] haystack, int needle) {
		
		int low = 0, high = haystack.length - 1;
		
		while(low <= high) {
			int mid = low + ((high - low)/2);
			
			if( (haystack[mid] - needle) > 0 )
				high = mid - 1;
			else if( (haystack[mid] - needle) < 0 )
				low = mid + 1;
			else
				return mid;
		}
		
		return -1;
		
	}
	
	/**
	 * Check if integer exists in set using binary search algorithm
	 * @param integer to search for
	 * @return true if found otherwise false
	 */
	public boolean member(int element) {		
		if(binarySearch(sortedArray, element) >= 0) {
			return true;
		}
		
		return false;
	}
}
