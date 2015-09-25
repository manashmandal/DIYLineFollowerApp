package electroscholars.com.diylinefollowerrobot;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.view.View;
import android.app.ActionBar;


public class ArduinoCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        ArrayAdapter <ArduinoClass> arduinoClassArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ArduinoClass.arduinoItems);
        listView.setAdapter(arduinoClassArrayAdapter);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Introduction to Arduino");
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        Intent intent = new Intent(ArduinoCategoryActivity.this, ArduinoView.class);
        intent.putExtra(ArduinoView.ARDUINO_ITEM_NO, (int) id);
        startActivity(intent);
    }

}
