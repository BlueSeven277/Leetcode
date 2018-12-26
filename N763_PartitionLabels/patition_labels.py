class Solution(object):

    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        ans = []
        last_appear = []
        for i in range(26):
            last_appear.append(0)
        for i in range(len(S)):
            last_appear[ord(S[i])-ord('a')] = i  #record where each letter final appear
        j = 0
        last_time = 0
        for i in range(len(S)):
            j = max(j,last_appear[ord(S[i])-ord('a')])
            if i == j:
                ans.append(j-last_time+1)
                last_time = j+1
        return ans

S = "ababcbacadefegdehijhklij"
instance = Solution()
print instance.partitionLabels(S)

