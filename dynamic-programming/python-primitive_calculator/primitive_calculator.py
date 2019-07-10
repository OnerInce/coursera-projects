# Uses python3
# Only operations : x * 2, x * 3, x + 1

# Function to fill 'sequence' list according to numbers' shortest path's length
# shortest path = 'minimum number of operations to reach 1'


def create_shortest_path(number, sequence):
    if sequence[number] is not None:
        return sequence[number]
    mult3 = mult2 = None
    min_list = list()
    if number % 3 == 0:
        divided_three = number // 3
        mult3 = create_shortest_path(divided_three, sequence) + 1
    if number % 2 == 0:
        divided_two = number // 2
        mult2 = create_shortest_path(divided_two, sequence) + 1
    minus_one = create_shortest_path(number - 1, sequence) + 1

    min_list.extend((mult3, mult2, minus_one))
    min_list = list(filter((None).__ne__, min_list))
    smallest = min(min_list)  # Find the minimum possible route
    sequence[number] = smallest

    return smallest

# Function to find the number's shortest route to 1 to the inside of the 'stack' list


def find_result(number, sequence, stack):

    if number == 0:
        return

    divided_three = divided_two = None
    min_list = list()
    if number % 3 == 0:
        divided_three = number // 3
    if number % 2 == 0:
        divided_two = number // 2
    minus_one = number - 1

    min_list.extend((divided_three, divided_two, minus_one))
    min_list = list(filter((None).__ne__, min_list))
    min_seqs = [sequence[x] for x in min_list]  # Get the shortest path
    smallest_seq = min(min_seqs)
    index_of_min = min_seqs.index(smallest_seq)
    smallest_value = min_list[index_of_min]
    stack.append(smallest_value)  # Add to the stack
    return find_result(smallest_value, sequence, stack)


target = int(input())
sequence = list()
sequence.extend((0, 0))

stack = list()
stack.append(target)

for i in range(target - 1):
    sequence.append(None)

for m in range(target + 1):  # Iterate all numbers to find all numbers' shortest path
    if m == 0 or m == 1:continue
    create_shortest_path(m, sequence)

find_result(target, sequence, stack) # Fill the stack with number
stack = list(filter((0).__ne__, stack))
print(len(stack) - 1)
stack.reverse()
for x in stack:
    print(x, end=' ')
