# python-car_fuel

Going to travel to another city that is located 𝑑 miles away from home city. Car can travel
at most 𝑚 miles on a full tank and car will start with a full tank. Along the way, there are gas stations at
distances stop1, stop2, . . . , stop𝑛 from home city. What is the minimum number of refills needed?


Input Format. 

The first line contains an integer 𝑑. The second line contains an integer 𝑚. The third line
specifies an integer 𝑛. Finally, the last line contains integers stop1, stop2, . . . , stop𝑛.

Outut Format. 

Assuming that the distance between the cities is 𝑑 miles, a car can travel at most 𝑚 miles
on a full tank, and there are gas stations at distances stop1, stop2, . . . , stop𝑛 along the way, output the
minimum number of refills needed. Assume that the car starts with a full tank. If it is not possible to
reach the destination, output −1.

Constraints. 

1 ≤ 𝑑 ≤ 105. 1 ≤ 𝑚 ≤ 400. 1 ≤ 𝑛 ≤ 300. 0 < stop1 < stop2 < · · · < stop𝑛 < 𝑑.