# java-baby_datas

For this assignment, providing data on baby names from the United States and will answer questions about this data. 
The data files give information on the first names of people born in a particular year. Have data from 1880 through 2014 on both boys and girls names. 
You can find all baby name data on us_babynames folder.

The files lists all the girls first, and they are listed in order based on the number of births, from largest numbers to smallest numbers. 

Aim is to write a program with several methods and tester methods to test each these methods.

**totalBirths** : print the number of girls names , the number of boys names and the total names in the file.

**getRank** : has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). 
This method returns the rank of the name in the file for the given gender, where rank 1 is the name with the largest number of births. 
If the name is not in the file, then -1 is returned. 

**getName** : has three parameters: an integer named year, an integer named rank, and a string named gender (F for female and M for male). 
This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. 
If the rank does not exist in the file, then “NO NAME” is returned.

*What would your name be if you were born in a different year?* **whatIsNameInYear** : that has four parameters: a string name, an integer named year representing the year that name was born, an integer named newYear and a string named gender (F for female and M for male). 
This method determines what name would have been named if they were born in a different year, based on the same popularity. 
That is, it should determined the rank of name in the year they were born, and then print the name born in newYear that is at the same rank and same gender. 

**yearOfHighestRank** : has two parameters: a string name, and a string named gender (F for female and M for male). 
This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. 
If the name and gender are not in any of the selected files, it should return -1. 

**getAverageRank** : has two parameters: a string name, and a string named gender (F for female and M for male). 
This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. 
It should return -1.0 if the name is not ranked in any of the selected files.

**getTotalBirthsRankedHigher** : has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). 
This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than name. 
