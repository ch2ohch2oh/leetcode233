/**
 * id: 167 two sum ii -  input array is sorted
 * tags: two pointers
 * date: 2021-04-27
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;
        while(a < b) {
            int sum = numbers[a] + numbers[b];
            if(sum > target) {
                b--;
            } else if(sum < target) {
                a++;
            } else {
                return new int [] {a + 1, b + 1};
            }
        }
        return null;
    }
}