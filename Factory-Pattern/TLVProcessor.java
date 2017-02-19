import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class TLVProcessor {
    public static void main(String[] args) {
        /* Populating Outputs */
        PrintStream outStream = System.out;
        
        /* Receiving Inputs */
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader bufReader = new BufferedReader(inStream);
        String line;
        
        outStream.println("TLV Processor !!");
        outStream.println("Provide Input or Press Ctrl+C to Quit !!");
        
        try {
            
            // Loop until Inputs are available
            while((line = bufReader.readLine()) != null) {
                
                int begin = 0; 
                int end = line.length()-1;
                
                // Loop until end of Input String
                while(begin < end) {
                    
                    /* Read Next 6 Characters for TYPE and move current position to 7 Character
                     * ahead as we have to Skip the '-' present at the end of TYPE.
                     * */
                    String type = line.substring(begin, begin+6);
                    begin += 7;
                    
                    /* Read Next 4 Character for LENGTH */
                    String length = line.substring(begin, begin+4);
                    begin += 5;
                    
                    /* Read Next N Characters for VALUE where N is the length we just got */                
                    int N = Integer.parseInt(length);
                    String value = line.substring(begin, begin+N);
                    begin += N;
                    
                    /* Now we have TYPE and VALUE, find the suitable Processor */
                    Processor processor = ProcessorFactory.getProcessor(type, value);
                    
                    /* Got a suitable Processor */
                    if(processor != null) {                    
                        processor.doProcessing();
                        outStream.println(processor.getType() + "-" + processor.getValue());
                    }
                    else {
                        outStream.println("Type not valid");
                    }
                } // end of while
                
                outStream.println("");
                outStream.println("Provide Input or Press Ctrl+C to Quit !!");
            }

            inStream.close();
            outStream.close();
            bufReader.close();
        } 
        catch (NumberFormatException nfe) {
            outStream.println("Malformed TLV !!");
            nfe.getMessage();
        
        } 
        catch (IOException ioe) {
            ioe.getMessage();
        } 
        System.out.println("Thank You !!");
    }
}