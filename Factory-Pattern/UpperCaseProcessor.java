public class UpperCaseProcessor extends Processor {
    public UpperCaseProcessor(String type, String value) {
        super(type, value);
    }

    @Override
    public void doProcessing() {
        String currentValue = super.getValue();
        super.setValue(currentValue.toUpperCase());
    }
}
