package electroscholars.com.diylinefollowerrobot;

/**
 * Created by Manash on 9/24/2015.
 */
public class LFRClass implements ListClass {

    private String name;
    private String url;

    private LFRClass(String name){
        this.name = name;
        setUrl(this.name);
    }

    public static final LFRClass[] lfrItems = {
            new LFRClass("1. About Line Following Robots"),
            new LFRClass("2. Differential Drive Algorithm"),
            new LFRClass("3. Proportional Derivative Algorithm"),
            new LFRClass("4. Differential Drive Full Code"),
            new LFRClass("5. Proportional Derivative Full Code")
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
