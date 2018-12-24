# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        l =[]
        l = self.helperFunc(root,l)
        return l
    def helperFunc (self, root, l):
        if root==None:
            return
        self.helperFunc(root.left,l)
        l.append(root.val)
        self.helperFunc(root.right,l)
        return l

    def inorderTraversal2(self, root):
        l = []
        stack = []
        current = root
        stack.append(current)

        while (True):
            if len(stack)==0:
                break
            current = stack[-1]
            if current.left!=None:
                stack.append(current.left)
                current = current.left
                stack[-2].left =None
            else:
                l.append(stack[-1].val)
                stack.pop()
                if current.right!=None:
                    current = current.right
                    stack.append(current)
        return l

    def inorderTraversal3(self, root):
        res, stack = [], []
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack:  #None,False,0,emptyList,emptyDictionary,emptyTuple are False,
                #  hence, not stack=True ==> stack is False , is empty
                return res
            node = stack.pop()
            res.append(node.val)
            root = node.right





s = Solution()
root = TreeNode(1)
right = root.right = TreeNode(2)
right.left = TreeNode(3)
print s.inorderTraversal3(root)