# Uses python3
# coins = 1, 3, 4


def get_change(money, min_coin_list, coins):
    for i in range(money + 1):  # Fill the min_coin_list
        if i == 0: continue
        for m in coins:  # Iterate all coins to find minimum
            if i >= m:
                amount = min_coin_list[i - m] + 1
                if min_coin_list[i] is None or min_coin_list[i] > amount:
                    # If there is minimum number of coins, change value
                    min_coin_list[i] = amount

    return min_coin_list[money]


if __name__ == '__main__':
    money = int(input())

    min_coin_list = list()
    min_coin_list.append(0)

    for i in range(money):
        min_coin_list.append(None)

    coins = list()
    coins.extend((1,3,4))
    print(get_change(money, min_coin_list, coins))
