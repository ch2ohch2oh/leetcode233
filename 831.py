# 831 masking-personal-information
# Keywords:
#   string, regular expression
# Solution:
#   Using regular expression would be better
import re
class Solution:
    def maskPII(self, S: str) -> str:
        S = S.lower()
        if '@' in S:
            at_idx = S.find('@')
            return S[0] + '*' * 5 + S[at_idx - 1:]
        else:
            digits = ''.join(filter(lambda x: x.isdigit(), S))
            local_s = '***-***-' + digits[-4:]
            if len(digits) > 10: # global number
                return '+' + '*' * (len(digits) - 10) + '-' + local_s
            else:
                return local_s
            