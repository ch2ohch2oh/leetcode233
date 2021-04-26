/**
 * id: 88 merge sorted array
 * tags: sort
 * date: 2021-04-25
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums = new int[m+n];
        int i=0, j=0, k=0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        if(i == m) {
            while(j < n) {
                nums[k++] = nums2[j++];
            }
        } else {
            while(i < m) {
                nums[k++] = nums1[i++];
            }
        }
        System.arraycopy(nums, 0, nums1, 0, m + n);
    }
}