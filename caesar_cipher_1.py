# Code by Ammar Ahmed

import sys

n = int(input().strip())
s = input().strip()
k = int(input().strip())

a = "abcdefghijklmnopqrstuvwxyz"

for i in s:
    j = 0
    if (i.lower() in a):
        if (i.isupper()):
            print(a[(k+a.index(i.lower()))%26].upper(), end='')
        else:
            print(a[(k+a.index(i))%26], end='')
    else:
        print (i, end='')
    j += 1