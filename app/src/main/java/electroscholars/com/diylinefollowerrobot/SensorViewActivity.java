package electroscholars.com.diylinefollowerrobot;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.app.ActionBar;


    public class SensorViewActivity extends Activity {


        public static final String ITEM_NO = "ItemNo";

        private WebView sensorWebView;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_sensor_view);
        //Getting the webview id
        sensorWebView = (WebView) findViewById(R.id.sensorWebView);
        //Getting selected item index
        int itemNo = (Integer) getIntent().getExtras().get(ITEM_NO);
        //Initializing a temporary object from the index
        SensorClass theItem = SensorClass.sensorItems[itemNo];
        //Loading url using webView
        sensorWebView.loadUrl(theItem.getUrl());
        //Changing the name of actionbar
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(theItem.getName());

    }
}