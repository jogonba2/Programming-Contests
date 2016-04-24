#!/usr/bin/env python
# -*- coding: utf-8 -*-

s = """8000 1400
6008 1300
6000 2100
6000 2000
6000 1200
2000 1900
1100 3000
1000 4000"""

def lis(arr):
    n = len(arr)
 
    # Declare the list (array) for LIS and initialize LIS
    # values for all indexes
    lis = [1]*n
 
    # Compute optimized LIS values in bottom up manner
    for i in range (1 , n):
        for j in range(0 , i):
            if arr[i] > arr[j] and lis[i]< lis[j] + 1 :
                lis[i] = lis[j]+1
 
    # Initialize maximum to 0 to get the maximum of all
    # LIS
    maximum = 0
 
    # Pick maximum of all LIS values
    for i in range(n):
        maximum = max(maximum , lis[i])
 
    return lis
# end of lis function
 
# Driver program to test above function
arr = [10, 22, 9, 33, 21, 50, 41, 60]
print "Length of LIS is", lis(arr)
"""
s = s.split("\n")
W = []
S = []
for i in xrange(len(s)-1,0,-1):
    t = s[i]
    p = t.split(" ")
    W.append(int(p[0]))
    S.append(int(p[1]))
    

print LDS([1,3,5,2,7,8,9,0])"""
