def solution(x):
    sum = 0
    
    for i in str(x):
        temp = int(i)
        sum += temp
    
    if x%sum == 0:
        return True
    
    return False
