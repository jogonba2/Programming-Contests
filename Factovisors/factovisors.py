#!/usr/bin/env python
# -*- coding: utf-8 -*-


n = 1339167
m = 770158415

aux = 1
found = False
for i in xrange(n,2,-1):
    aux *= i
    if aux%m==0:
	print "DIVISIBLE"
	found = True
	break
	
if not found: print "NO DIVISIBLE"
