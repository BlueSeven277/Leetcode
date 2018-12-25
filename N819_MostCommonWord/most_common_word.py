class Solution(object):
    def helper(self,word, banned,occur_table):
        if word not in banned:
            if word in occur_table.keys():
                occur_table[word] = occur_table[word] + 1
            else:
                occur_table[word] = 1
        return occur_table

    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        # word_list = paragraph.strip().split(" ")
        occur_table = {}
        slow = 0
        for fast in range(len(paragraph)):
            if fast==len(paragraph)-1:
                word = paragraph[slow:].lower()
                occur_table = self.helper(word, banned, occur_table)
            if paragraph[fast].isalpha()==False :
                word = paragraph[slow:fast].lower()
                if word == "":
                    slow = fast+1
                    continue
                occur_table = self.helper(word,banned,occur_table)
                slow = fast+1
        maxnum = 0
        word =""
        for term in occur_table.keys():
            if occur_table[term]>maxnum:
                word = term
                maxnum = occur_table[term]
        return word




        # for item in word_list:
        #     try:
        #         if item[0].isalpha() == False:
        #             item = item[1:]
        #     except IndexError:
        #         print "Error: "+item
        #     # if item[0].isalpha() == False:
        #     #     item = item[1:]
        #     if item[-1].isalpha() == False:
        #         item = item[:-1]
        #     item = item.lower()
        #     if item not in banned:
        #         if item in occur_table.keys():
        #             occur_table[item] = occur_table[item]+1
        #         else:
        #             occur_table[item] = 1
        # maxnum = 0
        # word =""
        # for term in occur_table.keys():
        #     if occur_table[term]>maxnum:
        #         word = term
        #         maxnum = occur_table[term]
        # return word

#paragraph = "Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. Bob hit a ball the hit BALL flew far after it was hit. "

paragraph = "Bob. hIt, baLl"
banned = ["bob", "hit"]
s = Solution()
print Solution.mostCommonWord(s,paragraph,banned)
