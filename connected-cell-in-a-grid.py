# Enter your code here. Read input from STDIN. Print output to STDOUT
n = int(raw_input())
m = int(raw_input())
count = 0
cell = []

for i in range(0, n):
    new = []
    for j in range(0, m):
        new.append(0)
    cell.append(new)


for i in range(0, n):
    k = 0
    for j in map(int, raw_input().split()):
        cell[i][k] = j
        k = k + 1


for i in range(0, n):
    for j in range(0, m):
        if cell[i][j] == 1:
            cell[i][j] += count
            count = count + 1


for i in range(0, n):
    for j in range(0, m):
        # right
        if j+1 < m and cell[i][j] > 0 and cell[i][j+1] > 0:
            cell[i][j+1] = min(cell[i][j], cell[i][j+1])
            if cell[i][j] > cell[i][j+1]:
                cell[i][j] = cell[i][j+1]
        # right-down
        if i+1 < n and j+1 < m and cell[i][j] > 0 and cell[i+1][j+1] > 0:
            cell[i+1][j+1] = min(cell[i][j], cell[i+1][j+1])
            if cell[i][j] > cell[i+1][j+1]:
                cell[i][j] = cell[i+1][j+1]
        # down
        if i+1 < n and cell[i][j] > 0 and cell[i+1][j] > 0:
            cell[i+1][j] = min(cell[i][j], cell[i+1][j])
            if cell[i][j] > cell[i+1][j]:
                cell[i][j] = cell[i+1][j]
        # left-down
        if j-1 >= 0 and i+1 < n and cell[i][j] > 0 and cell[i+1][j-1] > 0:
            cell[i+1][j-1] = min(cell[i][j], cell[i+1][j-1])
            if cell[i][j] > cell[i+1][j-1]:
                cell[i][j] = cell[i+1][j-1]
        # up
        if i-1 >= 0 and cell[i][j] > 0 and cell[i-1][j] > 0:
            cell[i-1][j] = min(cell[i][j], cell[i-1][j])
            if cell[i][j] > cell[i-1][j]:
                cell[i][j] = cell[i-1][j]
        # right-up
        if i-1 >= 0 and j+1 < m and cell[i][j] > 0 and cell[i-1][j+1] > 0:
            cell[i-1][j+1] = min(cell[i][j], cell[i-1][j+1])
            if cell[i][j] > cell[i-1][j+1]:
                cell[i][j] = cell[i-1][j+1]


my_sum = [0]*(count+1)


for i in range(0, n):
    for j in range(0, m):
        if cell[i][j] > 0:
            my_sum[cell[i][j]] += 1

print max(my_sum)
