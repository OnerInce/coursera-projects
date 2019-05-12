import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    
    public void totalBirths(FileResource fr){
        
      int totalBorn = 0;
      int femaleBorn = 0, maleBorn = 0;
     
      int boysCount = 0, girlsCount = 0, totalCount = 0;
        
      for(CSVRecord rec : fr.getCSVParser(false))  {
          
        int numBorn = Integer.parseInt(rec.get(2));
        totalBorn += numBorn;
        if(rec.get(1).equals("F")){
            
            femaleBorn += numBorn;
            girlsCount += 1;
            
        }
        
        else if(rec.get(1).equals("M")){
            
            maleBorn += numBorn;
            boysCount += 1;
            
        }
          
      }
      
      totalCount = boysCount + girlsCount;
      
      System.out.println("TOTAL BIRTHS : " + totalBorn);
      System.out.println("FEMALE BIRTHS : " + femaleBorn);
      System.out.println("MALE BIRTHS : " + maleBorn);
      System.out.println("MALE COUNT : " + boysCount);
      System.out.println("GIRL COUNT : " + girlsCount);
      System.out.println("TOTAL COUNT : " + totalCount);
    }
    
    public void testTotalBirths(){
        
        FileResource fr = new FileResource("yob1905.csv");
        totalBirths(fr);
        
    }
    
    public int getRank(int year, String name, String gender){
        
        int currentRank = 0;
        String fileName = "yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord record : fr.getCSVParser(false)){
            
            
            if(record.get(1).equals(gender)){
                
                currentRank += 1;
                
                if(record.get(0).equals(name)){
                return currentRank;
            }
            
        }
            
       }
        return -1;
    }
    
    public void testGetRank(){
        
        System.out.println(getRank(1971, "Frank", "M"));
        
    }
    
    public String getName(int year, int rank, String gender){
        
        int currentRank = 0;
        String fileName = "yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord record : fr.getCSVParser(false)){
            
            if(record.get(1).equals(gender)){
                
                currentRank += 1;
                
                if(currentRank == rank){
                    
                 String name = record.get(0);
                 return name;
                }
                
            }
            
        }
        return "NO NAME";
    }
    
    public void testGetName(){
        
        System.out.println(getName(1982, 450, "M"));
        
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        
        int targetRank = getRank(year, name, gender);
        String targetName = getName(newYear, targetRank, gender);
        
        System.out.println(name + " born in " + year + " would be " + targetName + " if he was born in " + newYear);
        
    }
    
    public void testwhatIsNameInYear(){
        
        whatIsNameInYear("Owen", 1974, 2014, "M");
        
    }
    
    public int yearOfHighestRank(String name, String gender){
        
        DirectoryResource dr = new DirectoryResource();
        
        int highestRank = 1000000, highestYear = -1;
        
        for(File f : dr.selectedFiles()){
            
            int year = Integer.parseInt(f.getName().substring(3,7));
            int currentRank = getRank(year, name, gender);
            if(currentRank < highestRank && currentRank != -1){
                
                highestRank = currentRank;
                highestYear = year; 
                
            }
        }

        
        return highestYear;
    }
    
    public void testYearOfHighestRank(){
        
        System.out.println(yearOfHighestRank("Mich", "M"));
        
    }
    
    public double getAverageRank(String name, String gender){
        
        DirectoryResource dr = new DirectoryResource();
        double totalRank = 0.0, totalFile = 0.0;
        double average = 0.0;
        for(File f : dr.selectedFiles()){
            totalFile += 1;
            int year = Integer.parseInt(f.getName().substring(3,7));
            int currentRank = getRank(year, name, gender);
            totalRank += currentRank;
        
        }
        average = totalRank / totalFile;
        return average;
    }
    
    public void testGetAverageRank(){
        
        System.out.println(getAverageRank("Robert", "M"));
        
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        
        int myRank = getRank(year, name, gender);
        int totalBirth = 0;
        
        String fileName = "yob" + year + ".csv";
        
        FileResource fr = new FileResource(fileName);
        for(CSVRecord record : fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                if(getRank(year, record.get(0), gender) < myRank){

                totalBirth += Integer.parseInt(record.get(2));
            }   
            }
        }
        return totalBirth;
    }
    
    public void testGetTotalBirthsRankedHigher(){
        
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
        
    }

}
