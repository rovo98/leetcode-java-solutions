package BinarySearch.Easy;

/**
 * Problem : Acceptance: 40.0%
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1, 3, 5, 6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1, 3, 5, 6], 2
 * Output: 1
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class SearchInsertPosition {
    // Solution one: ^
    // This algorithm's time complexity is (log n).
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] testArr = {1, 3, 5, 6};
        System.out.println("The input test array is the following:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println();
        int target = 4;
        System.out.println("And search the position for " + target + " is " +
                            sip.searchInsert(testArr,target));
    }
}
