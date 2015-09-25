package electroscholars.com.diylinefollowerrobot;

/**
 * Created by Manash on 9/24/2015.
 */
public class SensorClass implements ListClass {

    private String name, url;

    public static final SensorClass[] sensorItems = {
            new SensorClass("1. IR (Infra-Red) Sensors")
//            , new SensorClass("2. IR with Arduino")
    };

    private SensorClass(String name){

        this.name = name;
        setUrl(name);
    }

    @Override
    public String getName() {return this.name;}

    @Override
    public void setUrl(String theName){
        String theLink = link + theName.toLowerCase().replace(' ', '_') + html;
        this.url = theLink;
    }

    @Override
    public String toString() {return this.name; }

    @Override
    public String getUrl() {return this.url; }
}
