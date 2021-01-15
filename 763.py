class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        # We need an dict to keep track of when a letter last occurs
        last_seen = {}
        for idx in range(len(S)):
            c = S[idx]
            last_seen[c] = idx
            
        ans = []
        start = 0
        end = last_seen[S[0]]
        for idx in range(len(S)):
            c = S[idx]
            if last_seen[c] > end:
                end = last_seen[c]
            if idx == end:
                ans.append(end - start + 1)
                start = end + 1
        return ans