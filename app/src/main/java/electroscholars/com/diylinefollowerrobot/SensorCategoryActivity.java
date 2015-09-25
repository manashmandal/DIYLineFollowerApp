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

public class SensorCategoryActivity extends ListActivity{


    @Override
    public void onCreate(Bundle state){
        super.onCreate(state);
        ListView sensorListView = getListView();
        ArrayAdapter<SensorClass> beforeYouBeginClassArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SensorClass.sensorItems);
        sensorListView.setAdapter(beforeYouBeginClassArrayAdapter);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Introduction to Sensor");
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        Intent intent = new Intent(SensorCategoryActivity.this, SensorViewActivity.class);
        intent.putExtra(SensorViewActivity.ITEM_NO, (int) id);
        startActivity(intent);
    }
}
