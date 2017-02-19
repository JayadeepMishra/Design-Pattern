public abstract class Processor {

    private String type;
    private String value;
    
    public abstract void doProcessing();
    
    public Processor(String type, String value) {
        this.type = type;
        this.value = value;
    }
    
    protected void setValue(String value) {
        this.value = value;
    }
    
    public String getType() {
        return type;
    }
    
    public String getValue() {
        return value;
    }

}