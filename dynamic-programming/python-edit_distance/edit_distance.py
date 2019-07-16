# Uses python3

# Program to calculate edit distance between two words
# edit distance : minimum number of operations (insertions, deletions, and substitutions of symbols)
# to transform one string into another.


def edit_distance(first_word, second_word, matrix):

    first_len = len(first_word)
    second_len = len(second_word)

    for m in range(1, second_len + 1):
        for n in range(1, first_len + 1):
            # Calculate all 4 possible neighbor distances
            insertion = matrix[m][n - 1] + 1
            deletion = matrix[m - 1][n] + 1
            mismatch = matrix[m - 1][n - 1] + 1
            match = matrix[m - 1][n - 1]
            # Fill the table with corresponding value
            if first_word[n - 1] == second_word[m - 1]:
                matrix[m][n] = min(insertion, deletion, match)
            elif first_word[n - 1] != second_word[m - 1]:
                matrix[m][n] = min(insertion, deletion, mismatch)

    return matrix[second_len][first_len]


if __name__ == "__main__":
    word1 = list(input())
    word2 = list(input())

    # Create distance_matrix to store edit distances of all prefix combinations
    distance_matrix = [[None for x in range(len(word1) + 1)] for y in range(len(word2) + 1)]

    # Fill the first row and column
    for i in range(len(word1) + 1):
        distance_matrix[0][i] = i
    for j in range(len(word2) + 1):
        distance_matrix[j][0] = j

    print(edit_distance(word1, word2, distance_matrix))