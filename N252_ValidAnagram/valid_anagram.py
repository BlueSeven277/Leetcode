import collections;
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        counter1 = collections.Counter(s)
        counter2 = collections.Counter(t)
        if len(counter1)!=len(counter2):
            return False
        for key in counter2.keys():
            if counter2[key]!=counter1[key]:
                return False
        return True