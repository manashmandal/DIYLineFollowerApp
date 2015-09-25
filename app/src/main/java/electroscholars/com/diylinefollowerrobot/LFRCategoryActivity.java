package electroscholars.com.diylinefollowerrobot;

/**
 * Created by Manash on 9/24/2015.
 */
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.app.ActionBar;

public class LFRCategoryActivity extends ListActivity{


    @Override
    public void onCreate(Bundle state){
        super.onCreate(state);
        ListView lfrListView = getListView();

        ArrayAdapter<LFRClass> lfrClassArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LFRClass.lfrItems);

        lfrListView.setAdapter(lfrClassArrayAdapter);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Line Following Robot");
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        Intent intent = new Intent(LFRCategoryActivity.this, LFRViewActivity.class);
        intent.putExtra(LFRViewActivity.ITEM_NO, (int) id);
        startActivity(intent);
    }
}
