package electroscholars.com.diylinefollowerrobot;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.app.ActionBar;


public class BeforeYouBeginViewActivity extends Activity{
    public static final String BEFORE_YOU_BEGIN_ITEM_NO = "BeforeYouBeginItemNo";

    private WebView beforeYouBeginWebView;

    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.activity_before_you_begin_view);
        //Getting the webview id
        beforeYouBeginWebView = (WebView) findViewById(R.id.beforeYouBeginWebView);
        //Getting selected item index
        int itemNo = (Integer) getIntent().getExtras().get(BEFORE_YOU_BEGIN_ITEM_NO);
        //Initializing a temporary object from the index
        BeforeYouBeginClass theItem = BeforeYouBeginClass.beforeYouBeginItems[itemNo];
        //Loading url using webView
        beforeYouBeginWebView.loadUrl(theItem.getUrl());
        //Changing the name of actionbar
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(theItem.getName());

    }
}