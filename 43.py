# 43 multiply-strings
# Keywords:
#   array, math
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        def string_to_num(num_string):
            '''Convert a string to a digit list'''
            return [ord(c) - ord('0') for c in num_string[::-1]]
        
        def num_to_string(num):
            '''Convert a number list to a string'''
            return ''.join([f'{d}' for d in num[::-1]])
        
        def num_times_digit(l1, d):
            '''Multiply a large int and another int'''
            ans = []
            carry = 0
            for num in l1:
                val = carry + d * num
                carry = val // 10
                val %= 10
                ans.append(val)
            if carry:
                ans.append(carry)
            return ans
        
        def add_nums(l1, l2):
            '''Add two large integer with shift'''
            idx = 0
            carry = 0
            ans = []
            while idx < len(l1) or idx < len(l2):
                val1 = l1[idx] if idx < len(l1) else 0
                val2 = l2[idx] if idx < len(l2) else 0
                idx += 1
                val = val1 + val2 + carry
                carry = val // 10
                val %= 10
                ans.append(val)
            if carry:
                ans.append(carry)
            return ans
        
        if num1 == '0' or num2 == '0':
            return '0'
        
        ans = []
        l1 = string_to_num(num1)
        l2 = string_to_num(num2)
        # print(l1)
        # print(l2)
        # print(add_nums(l1, l2))
        # print(num_times_digit(l1, 2))
        for idx, d in enumerate(l1):
            ans = add_nums(ans, [0] * idx + num_times_digit(l2, d))
        return num_to_string(ans)