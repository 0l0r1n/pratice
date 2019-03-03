import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
class FirstLastPositionOfElementInArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            min(nums, 0, nums.length - 1, target),
            max(nums, 0, nums.length - 1, target)
        };
    }
    
    private int min(int[] nums, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low)/2;
            if ((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) return mid;
            else if (target > nums[mid]) return min(nums, mid + 1, high, target);
            else return min(nums, low, mid - 1, target);
        }
        return -1;
    }
    
    private int max(int[] nums, int low, int high, int target) {
        if (high >= low) { 
            int mid = low + (high - low)/2; 
            if ((mid == nums.length - 1 || target < nums[mid+1]) && nums[mid] == target) return mid; 
            else if (target < nums[mid]) return max(nums, low, (mid -1), target); 
            else return max(nums, (mid + 1), high, target); 
        } 
        return -1;
    }

}