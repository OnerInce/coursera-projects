# Uses python3


# Get nth Fibonacci number
def get_fibonacci(n):
    array = list()
    array.extend((0, 1))
    for i in range(2, n + 1):
        array.append(array[i - 1] + array[i - 2])
    return array[n]


def find_pisano_period(m):
    remainder_seq = list()
    remainder_seq.extend((0, 1))
    remainder = count = 0
    for i in range(2, m * m + 1):
        # Store remainders of the fibonacci numbers
        remainder_seq.append(remainder_seq[i - 1] + remainder_seq[i - 2])
        temp = remainder
        previous_remainder = temp
        remainder = remainder_seq[i] % m
        # If a new period is starting, return the ith step
        if previous_remainder == 0 and remainder == 1 and count != 0:
            return i - 1
        count = count + 1


def get_fibonacci_huge(n, m):
    # Find pisano period of m and calculate the modulo m of the n
    period = find_pisano_period(m)
    divided = n % period
    result = get_fibonacci(divided) % m
    return result


if __name__ == '__main__':

    numbers = input().split()
    fibonacci_number = int(numbers[0])
    modulo = int(numbers[1])
    print(get_fibonacci_huge(fibonacci_number, modulo))


