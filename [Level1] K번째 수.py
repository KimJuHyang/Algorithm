def solution(array, commands):
    answer = []
    
    for com in commands:
        i = com[0]-1;
        j = com[1];
        k = com[2]-1;
        
        cut = array[i:j]
        cut.sort()
        answer.append(cut[k]);
        
    return answer
