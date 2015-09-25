package electroscholars.com.diylinefollowerrobot;



/**
 * Created by Manash on 9/24/2015.
 */

public class BeforeYouBeginClass implements ListClass {

    private String name;
    private String url;

    private BeforeYouBeginClass(String name){
        this.name = name;
        setUrl(this.name);
    }

    public static final BeforeYouBeginClass[] beforeYouBeginItems = {
            new BeforeYouBeginClass("1. Prerequisite"),
            new BeforeYouBeginClass("2. Necessary Components and Equipment")

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