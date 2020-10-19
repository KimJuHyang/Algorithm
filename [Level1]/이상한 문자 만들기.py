def solution(s):
    answer = ''
    lists = s.split(" ")
    
    for i in lists:        
        temp = list(i)
        
        for j in range(len(temp)):
            if j == 0 or j%2 == 0:
                temp[j] = temp[j].upper()
            else:
                temp[j] = temp[j].lower()        
        
        answer += ''.join(temp) + ' '
        
    return answer[:-1]
