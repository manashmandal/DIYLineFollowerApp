package electroscholars.com.diylinefollowerrobot;

/**
 * Created by Manash on 9/24/2015.
 */

import android.app.ListActivity;


public interface ListClass  {
     static final String link = "file:///android_asset/";
     static final String html = ".html";

     void setUrl(String theLink);
     String getName();
     String getUrl();
     String toString();
}
