class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        l = [ ]
        if len(nums) <=1:
            p =[nums]
            return p
        for i in range(len(nums)):
            num = nums[i]
            sub = nums[0:i]+nums[i+1:]
            subnums = self.permute( sub)
            for list in subnums:
                list.append(num)
                l.append(list)
        return l

nums = [1]
s = Solution()
rt= Solution.permute(s,nums)
print rt
print len(rt)