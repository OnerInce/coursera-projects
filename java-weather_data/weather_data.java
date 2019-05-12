import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Assignment {
    
    public CSVRecord coldestHourInFile(CSVParser parser)
    
    {
        
        CSVRecord coldestRecord = null;
        
        for(CSVRecord currentRecord : parser){
            
         if(coldestRecord == null){
             
            coldestRecord = currentRecord; 
         
         }
         
         else{
            
         double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
         double coldestSoFar = Double.parseDouble(coldestRecord.get("TemperatureF"));
         
         if (currentTemp < coldestSoFar){
             
            coldestRecord = currentRecord; 
             
         }
         
         
         }
            
        }
        
        return coldestRecord;
        
    }
    
    public void testColdestHourInFile(){
        
     FileResource fr = new FileResource();
     CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
     System.out.println("COLDEST TIME : " + coldest.get("DateUTC") + "COLDEST TEMP : " + coldest.get("TemperatureF"));
     
        
    }
    
    public String fileWithColdestTemperature(){
        
    DirectoryResource dr = new DirectoryResource();  
    String coldestFileName = null;
    Double currentColdestTemp = 0.0;
    Double coldestTemp = 0.0;
    
    for(File f : dr.selectedFiles()){
        
        FileResource fr = new FileResource(f);
        
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        
        currentColdestTemp = Double.parseDouble(coldest.get("TemperatureF"));
        
        if(coldestFileName == null){
            
         coldestTemp = currentColdestTemp;  
         coldestFileName = f.getName();
            
        }
        
        else{
            
         if(currentColdestTemp < coldestTemp && currentColdestTemp != -9999){
             
           coldestTemp = currentColdestTemp; 
           coldestFileName = f.getName();
             
         }
            
        }
        
    }
    
    System.out.println("Coldest temperature on that day was " + coldestTemp);
    return coldestFileName;
}
    
    public void testFileWithColdestTemperature(){
        
     System.out.println(fileWithColdestTemperature());
        
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        
        CSVRecord lowestHumidityRecord = null;
        
        for(CSVRecord currentRecord : parser){
            
         if(lowestHumidityRecord == null && currentRecord.get("Humidity").equals("N/A") == false){
             
            lowestHumidityRecord = currentRecord; 
         
         }
         
         else{
             
             if(currentRecord.get("Humidity").equals("N/A") == false){
                 
                          int currentHumidity = Integer.parseInt(currentRecord.get("Humidity"));
                          int lowestHumiditySoFar = Integer.parseInt(lowestHumidityRecord.get("Humidity"));
                          
                                   if (currentHumidity < lowestHumiditySoFar){
             
                                       lowestHumidityRecord = currentRecord; 
             
                                    }
                 
                }
            }
         
         
         }
            return lowestHumidityRecord;
        }
        
        public void testLowestHumidityInFile(){
            
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser();
            CSVRecord csv = lowestHumidityInFile(parser); 
            System.out.println(csv.get("Humidity") + "  " + csv.get("DateUTC"));
            
        }
        
        public CSVRecord lowestHumidityInManyFiles(){
            
            DirectoryResource dr = new DirectoryResource();  
            CSVRecord lowestHumidityRecord = null;
            int currentHumidity = 0;
            int lowestHumidity = 0;
            
            for(File f : dr.selectedFiles()){
                
                FileResource fr = new FileResource(f);
                
                CSVRecord currentHumidityRecord = lowestHumidityInFile(fr.getCSVParser());
                
                currentHumidity = Integer.parseInt(currentHumidityRecord.get("Humidity"));
                
                if(lowestHumidity == 0.0){
                        
                     lowestHumidity = currentHumidity; 
                     lowestHumidityRecord = currentHumidityRecord;
                        
                }
                
                else{
                    
                 if(currentHumidity < lowestHumidity){
                     
                   lowestHumidity = currentHumidity;
                   lowestHumidityRecord = currentHumidityRecord;
                     
                 }
                    
                }
                
            }
            
            return lowestHumidityRecord;
                    
            
        }
        
        public void testLowestHumidityInManyFiles(){
            
            System.out.println("LOWEST HUMIDITY : " + lowestHumidityInManyFiles().get("Humidity") +   " DATE IS : " + lowestHumidityInManyFiles().get("DateUTC"));
            
            
        }
        
        public double averageTemperatureInFile(CSVParser parser){
            
            double totalTemp = 0.0;
            int tempCount = 0;
            
            for(CSVRecord currentRecord : parser){
                
                totalTemp += Double.parseDouble(currentRecord.get("TemperatureF"));
                tempCount += 1;
                
            }
            
            double averageTemp = totalTemp / tempCount;
            
            return averageTemp;
        }
        
        public void testAverageTemperatureInFile() {
            
                 FileResource fr = new FileResource();
                 double averageTemp = averageTemperatureInFile(fr.getCSVParser());
            
                 System.out.println("Average temp in this file is : " + averageTemp);
            
            
        }
        
        public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
            
            double totalTemp = 0.0;
            int tempCount = 0;
            
            for(CSVRecord currentRecord : parser){
                
                if(Integer.parseInt(currentRecord.get("Humidity")) >= value ){
                    
                    totalTemp += Double.parseDouble(currentRecord.get("TemperatureF"));
                    tempCount += 1;
                    
                }
                
            }
            double averageTemp = totalTemp / tempCount;
            
            if(totalTemp == 0.0){
                System.out.println("No temperatures with that humidity");
                return -1;
                
                
            }
            
            return averageTemp;
            
        }
        
        public void testAverageTemperatureWithHighHumidityInFile(){
            
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser();
            System.out.println(averageTemperatureWithHighHumidityInFile(parser, 80));
            
            
        }
        
    }
