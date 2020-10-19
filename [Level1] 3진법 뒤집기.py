def solution(n):

    list = []

    while(n > 0) :
        list.append(int(n%3))
        n = int(n/3)
    
    temp = []
    k = len(list)-1
    
    for i in list:
        temp.append(i * 3**k)
        k = k-1;

    return sum(temp)
