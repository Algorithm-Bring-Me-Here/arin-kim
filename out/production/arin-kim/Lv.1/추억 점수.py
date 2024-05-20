def solution(name, yearning, photo):
    answer = []
    for people in photo:
        total = 0
        for person in people:
            if person in name:  # 해당 이름이 name 리스트에 있는 경우
                i = name.index(person)
                total += yearning[i]
        answer.append(total)  # 해당 사람의 yearning 합을 결과 리스트에 추가
    return answer
