from functools import cache

class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        
        @cache
        def findMin(lastJob, days):
            # Find the answer for jobs 0 to lastJob in days
            if lastJob + 1 < days:
                return float('inf')
            if days == 1:
                return max(jobDifficulty[:lastJob + 1])
            maxDiff = jobDifficulty[lastJob]
            ans = float('inf')
            for start in range(lastJob + 1)[::-1]:
                maxDiff = max(maxDiff, jobDifficulty[start])
                ans = min(ans, maxDiff + findMin(start - 1, days - 1))
            return ans
        
        ans = findMin(len(jobDifficulty) - 1, d)
        if ans == float('inf'):
            return -1
        else:
            return ans
        
######## Nonrecursive solution ###############

from functools import cache

class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        
        njobs = len(jobDifficulty)
        
        # ans[jobs][days]
        ans = [[float('inf') for _ in range(d)] for _ in jobDifficulty]
        
        # day 0 
        ans[0][0] = jobDifficulty[0]
        for jobs in range(1, njobs):
            ans[jobs][0] = max(ans[jobs - 1][0], jobDifficulty[jobs])
        
        # day 1 to d - 1
        for day in range(1, d):
            for jobs in range(day, njobs):
                # do all the jobs from start to jobs today
                maxDiff = jobDifficulty[jobs]
                for start in range(day, jobs + 1)[::-1]:
                    maxDiff = max(maxDiff, jobDifficulty[start])
                    ans[jobs][day] = min(ans[jobs][day], maxDiff + ans[start - 1][day - 1])
        
        if ans[njobs - 1][d - 1] == float('inf'):
            return -1
        else:
            return ans[njobs - 1][d - 1]
