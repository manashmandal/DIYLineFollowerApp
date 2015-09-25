package electroscholars.com.diylinefollowerrobot;

import android.app.Activity;
import android.os.Bundle;
import android.app.ActionBar;
import android.webkit.WebView;


public class ArduinoView extends Activity {

    public static final String ARDUINO_ITEM_NO = "arduinoItemNo";

    private WebView arduinoWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arduino_view);
        arduinoWebView = (WebView) findViewById(R.id.arduinoWebView);
        int itemNo = (Integer) getIntent().getExtras().get(ARDUINO_ITEM_NO);
        ArduinoClass arduinoObject = ArduinoClass.arduinoItems[itemNo];
        arduinoWebView.loadUrl(arduinoObject.getUrl());
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(arduinoObject.getName());
    }

}
