# def foo(self,  l):
#     newList = []
#     for i in range(len(l)):
#         if i%2==0:
#             newList.append(l[i])

def foo(list):
    newList=[]
    for num in range(0,len(list)):
        if(num%2==0):
            newList.append(list[num]+1)
        else:
            newList.append(list[num]-1)
    return newList

l = [10,10,10,10,10]
print foo(l)