class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if (n == 1):
            return 1
        elif n ==2:
            return 2
        else:
            table =[]
            table.append(1)
            table.append(2)
            for i in range(2,n):
                table.append(table[i-1]+table[i-2])
            return table[n-1]
s = Solution()
print s.climbStairs(4)