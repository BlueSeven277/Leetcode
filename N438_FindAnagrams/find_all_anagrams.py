import collections


class Solution(object):
    def findAnagrams(self, s, p):

        """
        This method: Time Limit Exceeded
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        m = len(p)
        n = len(s)
        counter = collections.Counter(p)
        ans = []
        for i in range(n):
            curr_table = {}
            if i + m-1 < n:
                for j in range(i, i + m ):
                    if s[j] not in counter.keys():
                        break
                    else:
                        curr_table[s[j]] += 1
                        if curr_table[s[j]] > counter[s[j]]:
                            break
                        # if curr_table.has_key(s[j]):
                        #     if curr_table[s[j]] >= counter[s[j]]:
                        #         break
                        #     curr_table[s[j]] += 1
                        # else:
                        #     curr_table[s[j]] = 1
                        if j ==i+m-1:
                            ans.append(i)
        return ans



class Solution2(object):
    def findAnagrams(self, s, p):

        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        pCounter = collections.Counter(p)
        sCounter = collections.Counter(s[:len(p) - 1])
        for i in range(len(p) - 1, len(s)):
            sCounter[s[i]] += 1  # include a new char in the window
            if sCounter == pCounter:  # This step is O(1), since there are at most 26 English letters
                res.append(i - len(p) + 1)  # append the starting index
            sCounter[s[i - len(p) + 1]] -= 1  # decrease the count of oldest char in the window
            if sCounter[s[i - len(p) + 1]] == 0:
                del sCounter[s[i - len(p) + 1]]  # remove the count if it is 0
        return res


s = "cbaebabacd"
p = "abc"
so = Solution()
print so.findAnagrams(s, p)
