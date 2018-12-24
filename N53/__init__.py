class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if (len(nums)<=1):
            return nums[0]
        maxlist = []
        rt = nums[0]
        maxlist.append(nums[0])
        for i in range(1,len(nums)):
            maxsum = max(maxlist[i-1]+nums[i],nums[i])
            maxlist.append(maxsum)
            if maxsum > rt:
                rt = maxsum
        return rt

s = Solution()
nums = [-2,1,-3,4,-1,2,1,-5,4]
print s.maxSubArray(nums)