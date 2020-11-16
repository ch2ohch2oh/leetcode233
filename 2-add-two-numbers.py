# 2 add-two-numbers
# Keywords:
#   linked lists
# 
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode()
        cur = head
        carry = 0
        while l1 and l2:
            val = l1.val + l2.val + carry
            carry = val // 10
            val %= 10
            cur.next = ListNode(val)
            cur = cur.next
            l1 = l1.next
            l2 = l2.next
        if l2:
            l1 = l2
        while l1:
            val = l1.val + carry
            carry = val // 10
            val %= 10
            cur.next = ListNode(val)
            cur = cur.next
            l1 = l1.next
        if carry > 0:
            cur.next = ListNode(carry)
        return head.next

# A slightly better version
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # The first node is not used
        head = ListNode()
        cur = head
        carry = 0
        while l1 or l2:
            val1 = 0
            val2 = 0
            if l1:
                val1 = l1.val
                l1 = l1.next
            if l2:
                val2 = l2.val
                l2 = l2.next
            val = val1 + val2 + carry
            carry = val // 10
            val %= 10
            cur.next = ListNode(val)
            cur = cur.next
        # Do not forget the carry bit
        if carry:
            cur.next = ListNode(carry)
        return head.next
    