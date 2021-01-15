# 400 nth-digit
# Keywords:
#   math, string
# Better keep good comment of the code
class Solution:
    def findNthDigit(self, n: int) -> int:
        # Number of digits
        digits = 1
        # First index of the number with `digits` digits
        idx = 1
        while idx + digits * 9 * 10 ** (digits - 1) - 1 < n:
            idx = idx + digits * 9 * 10 ** (digits - 1)
            digits += 1
        skip = (n - idx) // digits
        remainder = (n - idx) % digits
        return str(10 ** (digits - 1) + skip)[remainder]