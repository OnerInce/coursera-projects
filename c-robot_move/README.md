# c-robot_move

Given an input string that controls the movement of a robot, "F" means take a step forward, "L" means turn 90 degrees to the left and "R" means turn 90 degrees to the right. E.g. "FLF" moves the robot one step forward, then turns it left by 90 degrees, then moves the robot one step forward. Function returns the number of commands that the robot needs to return to its starting point after following all the input commands. Ignore any characters that are not capital F, L, or R.

For example:

"RF" returns 3 (robot must turn twice and move forward one step (eg. "RRF")
"LFRFRFR" returns 1 (robot must step forward to return)
"FxLxLxFx" returns 0 (robot is already back at its starting point)
