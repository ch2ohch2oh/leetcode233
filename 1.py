# 1 two-sum
# Keywords: 
#   hashmap
# Solution:
#   First create a hashmap of num to its index.
#   Then scan the list from the beginning and try to find
#   if there is any element equals (target - num) using the hashmap.
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        position = {num: idx for idx, num in enumerate(nums)}
        for idx, num in enumerate(nums):
            if target - num in position.keys() and position[target - num] != idx:
                return [idx, position[target - num]]
            