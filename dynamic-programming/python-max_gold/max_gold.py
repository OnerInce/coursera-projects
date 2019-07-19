# Uses python3


def optimal_weight(capacity, bars, weights):

    for i in range(len(bars) + 1):
        if i == 0: continue
        for w in range(capacity + 1):
            if w == 0: continue
            weights[i][w] = weights[i - 1][w]          # Change with upper value
            current_weight = weights[i - 1][w]         # Assign current value to upper(replaced) value
            if bars[i - 1] <= w:                        # If bar fits the bag
                if current_weight < weights[i - 1][w - bars[i - 1]] + bars[i - 1]:   # If it is a bigger amount
                    weights[i][w] = weights[i - 1][w - bars[i - 1]] + bars[i - 1]
    return weights[len(bars)][capacity]


if __name__ == '__main__':
    first_input_line = input().split()
    bar_weights = input().split()

    first_input_line = [int(x) for x in first_input_line]
    bar_weights = [int(x) for x in bar_weights]
    bar_weights.sort()

    capacity = first_input_line[0]
    number_of_bars = first_input_line[1]

    # Create values matrix to store optimal solutions
    values = [[None for x in range(capacity + 1)] for y in range(number_of_bars + 1)]

    # Fill the 1st row and column with 0s
    for i in range(capacity + 1):
        values[0][i] = 0
    for j in range(number_of_bars + 1):
        values[j][0] = 0

    print(optimal_weight(capacity, bar_weights, values))
