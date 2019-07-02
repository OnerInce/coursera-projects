# Uses python3


def compute_min_refills(distance, tank, stops):
    stops.insert(0, 0)  # Add 0 point to the list
    stops.insert(len(stops), distance)  # Add destination to the list
    stops = [int(x) for x in stops]
    numberOfStops = len(stops) - 2
    numberOfRefills = currentRefill = 0
    while currentRefill <= numberOfStops:  # Iterate until there is no stops left
        lastRefill = currentRefill
        while currentRefill <= numberOfStops and stops[currentRefill + 1] - stops[lastRefill] <= int(tank):
            # Iterate until there is still stops left and between two stops are reachable
            currentRefill = currentRefill + 1
        if currentRefill == lastRefill:
            return -1
        elif currentRefill <= numberOfStops:
            numberOfRefills += 1
    return numberOfRefills


if __name__ == '__main__':
    d = input()
    m = input()
    n = input()
    stops = input().split()
    print(compute_min_refills(d, m, stops))