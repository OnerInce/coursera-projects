# Uses python3
import operator

# Dictionary to turn strings to operators
ops = {"+": operator.add, "-": operator.sub, "*": operator.mul, "/": operator.truediv}


# Iterate through all diagonals and fill maxes, mins matrixes
def place_parenthesis(digits, operators, mins, maxes):
    for i in range(len(digits)):
        mins[i][i] = digits[i]
        maxes[i][i] = digits[i] # Fill main diagonals
    for i in range(len(digits)):
        if i == 0: continue
        for j in range(len(digits) - i):
            mins[j][j + i] = min_and_max(j, j + i, operators, mins, maxes)[0]
            maxes[j][j + i] = min_and_max(j, j + i, operators, mins, maxes)[1]

    return maxes[0][len(digits) - 1]


# Find min and max values of the subexpression i, j
def min_and_max(i, j, operators, mins, maxes):

    largest = float("-inf")
    smallest = float("inf")

    return_array = list()

    for d in range(i, j):
        a = ops[operators[d]](maxes[i][d], maxes[d + 1][j])
        b = ops[operators[d]](maxes[i][d], mins[d + 1][j])
        c = ops[operators[d]](mins[i][d], mins[d + 1][j])
        d = ops[operators[d]](mins[i][d], maxes[d + 1][j])
        smallest = min(smallest, a, b, c, d)
        largest = max(largest, a, b, c, d)

    return_array.extend((smallest, largest))
    return return_array


if __name__ == "__main__":
    expression = list(input())

    digits = [int(x) if x.isdigit() else "" for x in expression]
    digits = list(filter(("").__ne__, digits))

    operators = [x if x.isdigit() is False else "" for x in expression]
    operators = list(filter(("").__ne__, operators))

    min_matrix = [[None for y in range(len(digits))] for x in range(len(digits))]
    max_matrix = [[None for y in range(len(digits))] for x in range(len(digits))]

    print(place_parenthesis(digits, operators, min_matrix, max_matrix))