package electroscholars.com.diylinefollowerrobot;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class LFRViewActivity extends Activity {

    public static final String ITEM_NO = "ItemNo";

    private WebView lfrWebView;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_lfrview);
        //Getting the webview id
        lfrWebView = (WebView) findViewById(R.id.lfrWebView);
        //Getting selected item index
        int itemNo = (Integer) getIntent().getExtras().get(ITEM_NO);
        //Initializing a temporary object from the index
        LFRClass theItem = LFRClass.lfrItems[itemNo];
        //Loading url using webView
        lfrWebView.loadUrl(theItem.getUrl());
        //Changing the name of actionbar
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(theItem.getName());

    }
}
