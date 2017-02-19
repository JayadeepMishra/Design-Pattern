public class ReplaceProcessor extends Processor {
    public ReplaceProcessor(String type, String value) {
        super(type, value);
    }

    @Override
    public void doProcessing() {
        super.setValue("THIS STRING");        
    }
}