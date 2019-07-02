# Uses python3


def optimal_summands(n):
    summands = list()
    addition = 1
    currentSum = 0
    # Add numbers until reach the n
    while currentSum + addition <= n :
        currentSum += addition
        summands.append(addition)
        addition += 1
    if sum(summands) == n:  # If it is exact our number n, return
        return summands
    diff = n - sum(summands)  # If we past n, then calculate the difference and adjust the last element
    summands[len(summands) - 1] += diff
    return summands


if __name__ == '__main__':
    number = int(input())
    result = optimal_summands(number)
    print(len(result))
    for x in result:
        print(x, end=' ')
