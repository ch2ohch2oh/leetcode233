from collections import Counter

class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        count = Counter()
        for t in time:
            count[t % 60] += 1
        
        # print(count)
        total = 0
        total += count[0] * (count[0] - 1) // 2
        for t in range(1, 30):
            total += count[t] * count[60 - t]
        total += count[30] * (count[30] - 1) // 2
        return total
    