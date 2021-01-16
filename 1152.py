class Solution:
    def mostVisitedPattern(self, username: List[str], timestamp: List[int], website: List[str]) -> List[str]:
        count = {}
        records = sorted(zip(username, timestamp, website))
        start = end = 0
        for end in range(len(records)):
            if records[start][0] == records[end][0]:
                for i in range(start, end):
                    for j in range(i + 1, end):
                        k = end
                        web3 = (records[i][2], records[j][2], records[k][2])
                        if web3 not in count:
                            count[web3] = set()
                        count[web3].add(records[i][0])
            else:
                start = end
        ans = []
        maxcount = 0
        for triple, users in count.items():
            if len(users) > maxcount:
                maxcount = len(users)
                ans = triple
            elif len(users) == maxcount and triple < ans:
                ans = triple
        return ans