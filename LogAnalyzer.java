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
        dayCounts = new int[29];
        monthCounts = new int[13]; 
        
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

   
    
    /**
     * 
     */
   public void analyzeData()
    {
         while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
            int day = entry.getDay();
            dayCounts[day]++;
            int month = entry.getMonth();
            monthCounts[month]++; 
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
        analyzeData(); 
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    /**
     * 
     */
    public void printDailyCounts()
    {
        analyzeData(); 
        System.out.println("Day: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
    }
    /**
     * 
     */
    public void printMonthCounts()
    {
        analyzeData(); 
        System.out.println("Month: Count");
        for(int month = 0; month < monthCounts.length; month++) {
            System.out.println(month + ": " + monthCounts[month]);
        }
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
     */
    public int quietestDay()
    {
            int numAccessesAtQuietest = numberOfAccesses();
            int quietestDay = 0;
            int i = 0;
            
            while(i < dayCounts.length - 1){
                if (numAccessesAtQuietest > dayCounts[i]){
                    quietestDay = i;
                    numAccessesAtQuietest = dayCounts[i];
                    i++;
                }
                else {
                    i++;
                }
            }
            return quietestDay;
    }
    
      public int quietestMonth()
    {
            int numAccessesAtQuietest = numberOfAccesses();
            int quietestMonth = 0;
            int i = 0;
            
            while(i < monthCounts.length - 1){
                if (numAccessesAtQuietest > monthCounts[i]){
                    quietestMonth = i;
                    numAccessesAtQuietest = monthCounts[i];
                    i++;
                }
                else {
                    i++;
                }
            }
            return quietestMonth;
    }
    
    public int busiestDay()
    {
            int numberOfAccesses = 0;
            int busiestDay = 0;
            int i = 0;
            
            while(i  < dayCounts.length)
            {
                if(numberOfAccesses < dayCounts[i])
                {
                    busiestDay = i; 
                    numberOfAccesses = dayCounts[i];
                    i ++;
                    
                }
                else {
                i++;
                
                }
                
            
    }
    return busiestDay; 
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
    * @return busiest hour
    * 
    */
       public int busiestMonth()
    {
            int numberOfAccesses = 0;
            int busiestMonth = 0;
            int i = 0;
            
            while(i  < monthCounts.length)
            {
                if(numberOfAccesses < monthCounts[i])
                {
                    busiestMonth = i; 
                    numberOfAccesses = monthCounts[i];
                    i ++;
                    
                }
                else {
                i++;
                
                }
                
            
    }
    return busiestMonth; 
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