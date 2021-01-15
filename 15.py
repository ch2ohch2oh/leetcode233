# 15 3sum
# Keywords: 
#   two pointers  
# Solution:
#   Convert to 2sum and take care of the 
#   duplicates.
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums = sorted(nums)
        ans = []
        for left, _ in enumerate(nums):
            # Get rid of the duplicates
            if left > 0 and nums[left] == nums[left-1]:
                continue
            # Now it's two sum with sorted input
            mid = left + 1
            right = len(nums) - 1
            while mid < right:
                triple = [nums[left], nums[mid], nums[right]]
                total = sum(triple)
                if total > 0:
                    right -= 1
                elif total < 0:
                    mid += 1
                else:
                    ans.append(triple)
                    while mid < right and nums[mid] == nums[mid + 1]:
                        mid += 1
                    mid += 1
        return ans
