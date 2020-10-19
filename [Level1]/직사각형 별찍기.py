a, b = map(int, input().strip().split(' '))

temp = ''

for i in range(b):
    for j in range(a):
        temp += '*'
    print(temp)
    temp = ''
