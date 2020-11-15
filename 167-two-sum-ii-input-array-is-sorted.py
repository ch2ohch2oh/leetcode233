# 167 two-sum-ii-input-array-is-sorted
# Keywords: 
#   two pointers
# Solution:
#   The answer is a pair (first, second).
#   Since the list is sorted, we can enumerate 
#   `first` from 0.
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        first = 0
        second = len(numbers) - 1
        while first < second:
            total = numbers[first] + numbers[second]
            if total == target:
                return [first + 1, second + 1]
            elif total > target:
                second -= 1
            else:
                first += 1
