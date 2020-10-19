def solution(answers):
    answer = [0,0,0]
    pattern_1 = [1,2,3,4,5]
    pattern_2 = [2,1,2,3,2,4,2,5]
    pattern_3 = [3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        
        if answers[i] == pattern_1[i%5] :
            answer[0] = answer[0]+1
        if answers[i] == pattern_2[i%8] :
            answer[1] = answer[1]+1
        if answers[i] == pattern_3[i%10] :
            answer[2] = answer[2]+1
        
    
    result = [];
    temp = max(answer)
    
    for i in range(len(answer)):
        if answer[i] >= temp :
            result.append(i+1)
    
    return result
