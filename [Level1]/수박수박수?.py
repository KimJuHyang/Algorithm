def solution(n):
    answer = ''
    list = [0,1]

    for i in range(n):
        if list[0] == 0: 
            answer += '수'
            list[0] = 1
            list[1] = 0
            continue;

        if list[1] == 0:
            answer += '박'
            list[1] = 1
            list[0] = 0

    return answer
