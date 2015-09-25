package electroscholars.com.diylinefollowerrobot;


import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;
import android.view.View;
import android.widget.ArrayAdapter;


public class BeforeYouBeginActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listBeforeYouBegin = getListView();
        ArrayAdapter<BeforeYouBeginClass> beforeYouBeginClassArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BeforeYouBeginClass.beforeYouBeginItems);
        listBeforeYouBegin.setAdapter(beforeYouBeginClassArrayAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        Intent intent = new Intent(BeforeYouBeginActivity.this, BeforeYouBeginViewActivity.class);
        intent.putExtra(BeforeYouBeginViewActivity.BEFORE_YOU_BEGIN_ITEM_NO, (int) id);
        startActivity(intent);
    }

}
