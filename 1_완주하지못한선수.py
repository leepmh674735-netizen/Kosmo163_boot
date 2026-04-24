# 1_완주하지못한선수.py
# (리스트 문제)
# 마라톤 경기 참여자(participant)와 완주자(completion)목록이 있습니다
# 완주하지 못한 사람은 1명입니다
# 참가자 중에는 동명이인이 있을 수 있습니다
# 1회, 2회, 3회차에 대한 완주하지 못한 선수를 찾아서 화면에 출력하세요

p1 = ['leo', 'kiki', 'eden']
c1 = ['eden', 'kiki']

p2 = ['marina', 'josipa', 'nikola', 'vinko', 'filipa']
c2 = ['josipa', 'filipa', 'marina', 'nikola']

p3 = ['mislav', 'stanko', 'mislav', 'ana']
c3 = ['stanko', 'ana', 'mislav']

participant = p3
completion = c3

### 정렬을 수행하고, 같은 인덱스의 이름이 서로 다르거나, 마지막값을 정답으로 출력하기 ###

print('1) 정렬 전')
print(participant)
print(completion)
print()

participant.sort()  # 원본을 정렬하려면, list.sort() 함수를 사용한다
completion.sort()   # 비슷한 두 리스트를 정렬하면 같은 index의 값은 같다 (다르면 정답)

print('2) 정렬 후')
print(participant)
print(completion)
print()

answer = participant[-1]    # 파이썬 인덱싱에서 -1을 넣으면 항상 마지막값을 참조한다
for i in range(len(completion)):
    if completion[i] != participant[i]:
        answer = participant[i]
        break
print(answer)

# 정렬 상태를 가정하고, 다른 방식으로 리스트 순회하기
# 두개의 리스트를 한번에 순회하는 방식
# zip() 함수를 이용하여 서로 다른 리스트를 묶어서 처리한다
answer = participant[-1]
for p, c in zip(participant, completion):
    if p != c:
        answer = p
        break
print(answer)

### dict를 이용하여 리스트에 포함된 횟수를 누적시키는 방식 ###
d1 = { p: 0 for p in participant }

# for p in participant:   # 참여자 이름으로, 카운트 횟수를 0으로 초기화한다
#     d1[p] = 0
print(d1)

for p in participant:   # 참여한 사람은 카운트를 1 증가시킨다
    d1[p] += 1
print(d1)

for c in completion:    # 완주한 사람은 카운트를 1 증가시킨다
    d1[c] += 1
print(d1)

for key in d1:          # 만약, 참여하고 완주했다면 카운트는 2, 동명이인이 있어도 짝수가 된다
    value = d1[key]
    if value % 2 != 0:  # 카운트가 짝수가 아니라면, 그 사람은 완주하지 못한 사람이다
        answer = key
print(answer)

### 참여자에서 완주자를 빼서 답을 구하기 ###
# participant.sort()
# answer = participant[-1]

for c in completion:
    print(participant)
    participant.remove(c)   # 참여자 목록에서 완주자 한명을 제거한다
answer = participant[0]
print(answer)

