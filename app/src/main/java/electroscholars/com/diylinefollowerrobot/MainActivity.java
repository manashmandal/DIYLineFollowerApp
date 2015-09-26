package electroscholars.com.diylinefollowerrobot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;

import javax.xml.transform.Source;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating an ItemClickListener for listview

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
          public void onItemClick(AdapterView<?> listView, View v, int position, long id){
              if (position == 0){
                  Intent beforeYouBeginIntent = new Intent(MainActivity.this, BeforeYouBeginActivity.class);
                  startActivity(beforeYouBeginIntent);
              } else if (position == 1) {
                  Intent arduinoIntent = new Intent(MainActivity.this, ArduinoCategoryActivity.class);
                  startActivity(arduinoIntent);
              } else if (position == 2){
                  Intent sensorIntent = new Intent(MainActivity.this, SensorCategoryActivity.class);
                  startActivity(sensorIntent);
              } else if (position == 3){
                  Intent lfrIntent = new Intent(MainActivity.this, LFRCategoryActivity.class);
                  startActivity(lfrIntent);
              } else if (position == 4){
                  Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
                  startActivity(quizIntent);
              }
          }
        };

        //Adding the listener to the listview
        ListView listView = (ListView) findViewById(R.id.top_list_options);
        listView.setOnItemClickListener(itemClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            showAboutDialog();
        } else if (id == R.id.source_code_and_reference){
            showSourceAndReference();
        } else if (id == R.id.license){
            showMITLicense();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showSourceAndReference(){
        AlertDialog.Builder showSourceDialog = new AlertDialog.Builder(this);
        showSourceDialog.setTitle("Source Code Link and Reference Book Used");
        String SourceCodeAndReference = "App Version: DIY Line Follower Robot v0.1 (beta)\n\n " + "Source Code: \n\nhttp://github.com/manashmndl/DIYLineFollowerApp\n\n" +
                "\nReference Books: \n\n1. Arduino Cookbook" +
                "\n2. Getting Started with Arduino by Massimo Banzi" +
                "\n3. ElectricRCAirCraftGuy.com"
                ;
        showSourceDialog.setMessage(SourceCodeAndReference);
        showSourceDialog.setCancelable(true);
        showSourceDialog.show();
    }


    public void showMITLicense(){

        AlertDialog.Builder licenseDialog = new AlertDialog.Builder(this);
        licenseDialog.setTitle("MIT Public License");
        String licenseText = "Copyright (c) 2015 Manash Kumar Mandal\n" +
                "\n" +
                "Permission is hereby granted, free of charge, to any person\n" +
                "obtaining a copy of this software and associated documentation\n" +
                "files (the \"Software\"), to deal in the Software without\n" +
                "restriction, including without limitation the rights to use,\n" +
                "copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
                "copies of the Software, and to permit persons to whom the\n" +
                "Software is furnished to do so, subject to the following\n" +
                "conditions:\n" +
                "\n" +
                "The above copyright notice and this permission notice shall be\n" +
                "included in all copies or substantial portions of the Software.\n" +
                "\n" +
                "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n" +
                "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES\n" +
                "OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND\n" +
                "NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT\n" +
                "HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,\n" +
                "WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING\n" +
                "FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR\n" +
                "OTHER DEALINGS IN THE SOFTWARE.";

        licenseDialog.setMessage(licenseText);
        licenseDialog.setCancelable(true);
        licenseDialog.show();

    }

    public void showAboutDialog(){
        CharSequence text = "Hello!\nI'm Manash Kumar Mandal\nEducation: EEE @ KUET, 2K12 Batch";
        CharSequence text2 = "Open Source Lover";
        CharSequence text3 = "Software Developer";
        CharSequence text4 = "Hardware Hobbyist";
        CharSequence text5 = "Interested in Robotics";
        CharSequence text6 = "Check My Projects @ http://github.com/manashmndl";
        CharSequence text7 = "Check out my blog @ http://medialab.electroscholars.com";
        CharSequence text8 = "Thank you for Using This App";
        
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        Toast.makeText(this, text2, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, text3, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, text4, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, text5, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, text6, Toast.LENGTH_LONG).show();
        Toast.makeText(this, text7, Toast.LENGTH_LONG).show();
        Toast.makeText(this, text8, Toast.LENGTH_LONG).show();
    }
}
