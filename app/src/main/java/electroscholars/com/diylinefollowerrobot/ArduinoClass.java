package electroscholars.com.diylinefollowerrobot;

/**
 * Created by Manash on 9/24/2015.
 */
public class ArduinoClass implements ListClass {

    private String name;
    private String url;

    private ArduinoClass(String name){
        this.name = name;
        setUrl(this.name);
    }

    public static final ArduinoClass[] arduinoItems = {
            new ArduinoClass("1. Digital Input Output"),
            new ArduinoClass("2. Pulse Width Modulation"),
            new ArduinoClass("3. Analog To Digital Conversion"),
            new ArduinoClass("4. Serial Communication"),
            new ArduinoClass("5. Helpful Arduino Resources")
    };

    @Override
    public String getName(){ return this.name; }

    @Override
    public String getUrl() {return this.url; }

    @Override
    public String toString() {return  this.name; }

    @Override
    public void setUrl(String theName){
        String theLink = link + theName.toLowerCase().replace(' ', '_') + html;
        this.url = theLink;
    }
}