# 3 longest-substring-without-repeating-characters
# Keywords:
#   two pointers
# Solution:
#   The answer is pair consisting of the
#   starting index and end index of the longest substring.
#   We can enumerate the starting index from 0.
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        prev_seen = dict()
        start = 0
        end = 0
        ans = 0
        while start <= end and end < len(s):
            if s[end] not in prev_seen:
                ans = max(ans, end - start + 1)
                prev_seen[s[end]] = end
            else:
                start = max(prev_seen[s[end]] + 1, start)
                prev_seen[s[end]] = end
                ans = max(ans, end - start + 1)
            # print(f'{s[end]} => {ans}')
            end += 1
        return ans