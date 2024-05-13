def solution(board, moves):
    row, col = len(board), len(board[0])
    answer = []
    count = 0
    for m in moves:
        for i in range(row):
            if board[i][m-1]:
                answer.append(board[i][m-1])
                board[i][m-1] = 0
                break

        if len(answer) > 1:
            if answer[-2] == answer[-1]:
                answer = answer[:-2]
                count += 2
    return count