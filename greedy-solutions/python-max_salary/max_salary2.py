# Uses python3


# Function to return how many digits x has
def howManyDigits(x):
    if x == 0: return 1
    result = 0
    while x > 0:
        x = x // 10
        result += 1
    return result


def greaterOrEqual(x, y):
    if x == 0 and y != 0: return False
    if y == 0: return True
    if howManyDigits(x) > howManyDigits(y):
        lastDigit = None
        xlist = list(str(x))
        ylist = list(str(y))
        while len(ylist) != 0:  # Iterate until one of the number's digits are finished
            currentXdigit = xlist[0]
            currentYdigit = ylist[0]
            if int(currentXdigit) > int(currentYdigit): return True
            elif int(currentXdigit) < int(currentYdigit): return False
            else:  # If digits are equal, remove digits from both numbers and continue
                lastDigit = ylist.pop(0)
                xlist.pop(0)
        if lastDigit < xlist.pop(0): return True # When one number's digits are finished, look for next digit and return
        else: return False
    elif howManyDigits(x) < howManyDigits(y):
        lastDigit = None
        xlist = list(str(x))
        ylist = list(str(y))
        while len(xlist) != 0:
            currentXdigit = xlist[0]
            currentYdigit = ylist[0]
            if int(currentXdigit) > int(currentYdigit): return True
            elif int(currentXdigit) < int(currentYdigit): return False
            else:
                lastDigit = xlist.pop(0)
                ylist.pop(0)
        if lastDigit < ylist.pop(0): return False
        else: return True
    else: # If both numbers have same number of digits, compare normally
        return x > y


# Function to calculate max value in list, according to greaterOrEqual function
def largest_number(a):
    result = ''
    while len(a) != 0:
        maxNumber = 0
        for number in a:
            if greaterOrEqual(int(number), maxNumber):
                maxNumber = int(number)
        result = result + str(maxNumber)  # Append maximum value to the result
        a.remove(str(maxNumber))
    return result


if __name__ == '__main__':
    howMany = input()
    numbers = input().split()
    print(largest_number(numbers))