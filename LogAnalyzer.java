/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts, dayCounts, monthCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        dayCounts = new int[31];
        monthCounts = new int[12]; 
        
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    
    /**
     * 7.14 numberOfAccesses method
     * @returns total
     */
    public int numberOfAccesses()
    {
        int total = 0;
     for(int hour = 0; hour<hourCounts.length; hour++)
     {
         total+= hourCounts[hour]; 
     }
     return total; 
    }
    
  
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        analyzeHourlyData(); 
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
   /**
    * @return busiest hour
    * 
    */
       public int busiestHour()
    {
            int numberOfAccesses = 0;
            int busiestHour = 0;
            int i = 0;
            
            while(i  < hourCounts.length)
            {
                if(numberOfAccesses < hourCounts[i])
                {
                    busiestHour = i; 
                    numberOfAccesses = hourCounts[i];
                    i ++;
                    
                }
                else {
                i++;
                
                }
                
            
    }
    return busiestHour; 
    }
    
    /**
     * @return second busiest hours
     */
       public int twobusiestHours()
    {
             int numberOfAccesses = 0;
            int busiestHour = 0;
            int i = 0;
            
            while(i < hourCounts.length - 1){
                if (numberOfAccesses < hourCounts[i] + hourCounts[ + 1]){
                    busiestHour = i;
                    numberOfAccesses = hourCounts[i] + hourCounts[i + 1];
                    i++;
                }
                else {
                    i++;
                }
            }
            return busiestHour;
    }  
    
       /**
     * 7.16 - Add a quietestHour  method. 
     * 
     */
     public int quietestHour()
    {
            int numAccessesAtQuietest = numberOfAccesses();
            int quietestHour = 0;
            int i = 0;
            
            while(i < hourCounts.length - 1){
                if (numAccessesAtQuietest > hourCounts[i]){
                    quietestHour = i;
                    numAccessesAtQuietest = hourCounts[i];
                    i++;
                }
                else {
                    i++;
                }
            }
            return quietestHour;
    }
    
    /**
     * 
     * 
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}