#Uses python3


def getMax(myList):
    max = None
    for i in range(len(myList)):
        if max is None or myList[i] > max:
            max = myList[i]

    return max


def max_dot_product(a, b):
    res = 0
    for i in range(len(a)):
        # For each list find the maximums and iterate for all elements
        maxValueA = getMax(a)
        a.remove(maxValueA)
        maxValueB = getMax(b)
        b.remove(maxValueB)
        res += maxValueA * maxValueB  # Add maximum product to the result
    return res


if __name__ == '__main__':
    numbers = input()
    firstSeq = [int(x) for x in input().split()]
    secondSeq = [int(x) for x in input().split()]
    print(max_dot_product(firstSeq, secondSeq))