import collections
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        counter = collections.Counter(s)
        for i in range(len(s)):
            if counter[s[i]]==1:
                return i
        return -1

s = "loveleetcode"
obj = Solution()
print obj.firstUniqChar(s)
