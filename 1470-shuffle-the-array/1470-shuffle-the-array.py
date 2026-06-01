class Solution(object):
    def shuffle(self, nums, n):
        m=len(nums)
        arr=[]
        p1=0
        p2=n
        while p1<n and p2<m:
            arr.append(nums[p1])
            arr.append(nums[p2])
            p1+=1
            p2+=1
        return arr

       
