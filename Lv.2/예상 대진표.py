def solution(n, a, b):
    answer = 0

    # 두 참가자가 같은 그룹에 속할 때까지 반복
    while a != b:
        # 각 참가자의 번호를 다음 라운드에 참가할 그룹 번호로 변경
        a = (a + 1) // 2
        b = (b + 1) // 2

        answer += 1

    return answer