# java-weather_data

This is a program to find the ​coldest​ day of the year and other interesting facts about thetemperature and humidity in a day. 
For this purpose, .csv files inside of the nc_weather folder have used. In the ​year​ folder there is a CSV file for every day of the year.
Aim is to write a program with several methods and tester methods to test each these methods.

​**coldestHourInFile** :​ that has one parameter, a CSVParser namedparser​. This method returns the ​CSVRecord​ with the coldest temperature in the file and 
thus all the information about the coldest temperature, such as the hour of the coldest temperature.

**​fileWithColdestTemperature​** : that has no parameters. This method returns a string that is the name of the file from selected files that has the coldest temperature.

**lowestHumidityInFile** :​ that has one parameter, a CSVParsernamed parser. This method returns the CSVRecord that has the lowest humidity. If there is a tie, then returns the first such record that was found.

**lowestHumidityInManyFiles** :​ that has no parameters. This method returns a CSVRecord that has the lowest humidity over all the files. If there is a tie, then returns the first such record that was found.

**averageTemperatureInFile** :​ that has one parameter, a CSVParser named parser. This method returns a double that represents the average temperature in the file.

**averageTemperatureWithHighHumidityInFile** :​ has two parameters, a CSVParser named parser and an integer named value. This method returns a double that represents the average temperature of only those temperatures
when the humidity was greater than or equal to value.
