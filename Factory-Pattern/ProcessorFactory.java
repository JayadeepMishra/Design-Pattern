public class ProcessorFactory {
    public static Processor getProcessor(String type, String value) {
        Processor processor;
        
        if(type.equalsIgnoreCase("UPPRCS"))
            processor = new UpperCaseProcessor(type, value);
        
        else if(type.equalsIgnoreCase("REPLCE"))
            processor = new ReplaceProcessor(type, value);
        
        else
            processor = null;

        return processor;
    }
}
