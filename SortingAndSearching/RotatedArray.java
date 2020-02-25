package SortingAndSearching;

public class RotatedArray {
    // The situation when all the numbers in nums array is
    // Not repeated.
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
        
            if (nums[start] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } 
        
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }

    // The situation when duplicate elements are allowed inside the array.
    public int searchDuplicate(int[] a, int target) {
        return searchDuplicate(a, 0, a.length - 1, target);
    }

    // Helper method
    public int searchDuplicate(int[] a, int left, int right, int target) {
        if (right < left) return -1;

        int middle = (left + right) / 2;
        if (target == a[middle]) return middle;

        if (a[left] < a[middle]) { // Left is normally ordered.
            if (a[left] <= target && target < a[middle]) {
                return searchDuplicate(a, left, middle - 1, target);
            } else {
                return searchDuplicate(a, middle + 1, right, target);
            }
        } else if (a[middle] < a[right]) {
            if (a[middle] < target && target <= a[middle]) {
                return searchDuplicate(a, middle + 1, right, target);
            } else {
                return searchDuplicate(a, left, middle - 1, target);
            }
        }  else {
            int location = -1;
            if (a[left] == a[middle]) {
                location = searchDuplicate(a, middle + 1, right, target);
            }

            if (location == -1 && a[middle] == a[right]) {
                location = searchDuplicate(a, left, middle - 1, target);
            }
            return location;
        }
       
    }
}