package electroscholars.com.diylinefollowerrobot;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.app.AlertDialog;


public class QuizActivity extends Activity {

    private final static String positiveButtonLabel = "SHOW ANSWER";
    private final static String otherPositiveButtonLabel = "OK";

    private static int score = 0;

    private RadioButton arduinoUno;
    private RadioButton arduinoZero;
    private EditText question2EditText;
    private Spinner question3Spinner;

    private RadioButton ddRadioButton;
    private RadioButton pdRadioButton;
    private Switch question5Option1;
    private Switch question5Option2;
    private Switch question5Option3;
    private Switch question5Option4;

    private CheckBox mapCheckBox;
    private CheckBox constrainCheckBox;
    private CheckBox userDefinedCheckBox;

    private ActionBar actionBar;

    private AlertDialog.Builder dialogBox;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        arduinoUno = (RadioButton) findViewById(R.id.uno);
        question2EditText = (EditText) findViewById(R.id.question2EditText);
        question3Spinner = (Spinner) findViewById(R.id.question3Spinner);
        pdRadioButton = (RadioButton) findViewById(R.id.pdRadioButton);
        ddRadioButton = (RadioButton) findViewById(R.id.ddRadioButton);

        question5Option1 = (Switch) findViewById(R.id.question5Option1);
        question5Option2 = (Switch) findViewById(R.id.question5Option2);
        question5Option3 = (Switch) findViewById(R.id.question5Option3);
        question5Option4 = (Switch) findViewById(R.id.question5Option4);

        mapCheckBox = (CheckBox) findViewById(R.id.mapCheckBox);
        constrainCheckBox = (CheckBox) findViewById(R.id.constrainCheckBox);
        userDefinedCheckBox = (CheckBox) findViewById(R.id.userDefinedCheckBox);

        arduinoZero = (RadioButton) findViewById(R.id.zero);

        actionBar = getActionBar();
        actionBar.setTitle("Take the Quiz!");

        dialogBox = new AlertDialog.Builder(this);
        dialogBox.setTitle("Final Score");

        dialogBox.setCancelable(true);

        dialogBox.setPositiveButton(positiveButtonLabel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                AlertDialog.Builder otherDialog = new AlertDialog.Builder(dialogBox.getContext());
                otherDialog.setTitle("Answer Sheet");

                String message = "Q1. Arduino Zero" +
                                 "\nQ2. 255" +
                                 "\nQ3. analogRead(A5);" +
                                 "\nQ4. Proportional Derivative" +
                                 "\nQ5. i) False ii) True iii) True iv) False" +
                                 "\nQ6. Option 1 and 3";

                otherDialog.setMessage(message);

                otherDialog.setPositiveButton(otherPositiveButtonLabel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });

                otherDialog.show();
            }
        });
    }


    public void evaluateAnswer(View view){
        QuizActivity.resetScore();

        String pwm_string;
        int pwm_value = 0;
        boolean uno =  arduinoUno.isChecked();
        boolean zero = arduinoZero.isChecked();

        pwm_string = question2EditText.getText().toString();

        if (!pwm_string.equals("")) pwm_value = Integer.parseInt(pwm_string);

        boolean pdCheck = pdRadioButton.isChecked();
        boolean baudRateCheck = question5Option1.isChecked();
        boolean motorDriverCheck = question5Option2.isChecked();
        boolean pwmCheck = question5Option3.isChecked();
        boolean motorCheck = question5Option4.isChecked();

        boolean mapCheck = mapCheckBox.isChecked();
        boolean constrainCheck = constrainCheckBox.isChecked();
        boolean userDefinedCheck = userDefinedCheckBox.isChecked();

        String answer = question3Spinner.getSelectedItem().toString();

        if (pwm_value == 255) QuizActivity.score++;
        if (!uno && zero) QuizActivity.score++;
        if (answer.equals("analogRead(A5);")) QuizActivity.score++;
        if (pdCheck) QuizActivity.score++;


        if (!(!motorCheck && !motorDriverCheck && !mapCheck && !baudRateCheck)){
            if (!baudRateCheck) QuizActivity.score++;
            if (!motorCheck) QuizActivity.score++;
            if (pwmCheck) QuizActivity.score++;
            if (motorDriverCheck) QuizActivity.score++;
        }

        if (mapCheck && userDefinedCheck && !constrainCheck) QuizActivity.score++;

        if (QuizActivity.score == 9) {
            dialogBox.setMessage("Congratulations for perfect Score!" + "\n" + QuizActivity.scoreToString());
        } else if (QuizActivity.score > 5 && QuizActivity.score < 9) {
            dialogBox.setMessage("A Very good job! Try again" + "\n" + QuizActivity.scoreToString());
        } else if (QuizActivity.score < 5 && QuizActivity.score > 1) {
            dialogBox.setMessage("Aim for the perfect score!" + "\n" + QuizActivity.scoreToString());
        } else if (QuizActivity.score == 0){
            dialogBox.setMessage("Oh you haven't answered anything!" + "\n" + QuizActivity.scoreToString());
        }

        dialogBox.show();
        resetAllGUIComponents();
    }

    //Returns score in integer type
    public static int getScore() { return score; }

    //Returns score in String
    public static String scoreToString() { return String.format("Your Score is: %d", QuizActivity.getScore()); }

    //Reset the score
    public static void resetScore() {QuizActivity.score = 0; }

    //Resets all gui components
    private void resetAllGUIComponents(){
        arduinoUno.setChecked(false);
        arduinoZero.setChecked(false);
        question2EditText.setText("");
        question3Spinner.setSelection(0);
        pdRadioButton.setChecked(false);
        ddRadioButton.setChecked(false);
        question5Option1.setChecked(false);
        question5Option2.setChecked(false);
        question5Option3.setChecked(false);
        question5Option4.setChecked(false);
        mapCheckBox.setChecked(false);
        constrainCheckBox.setChecked(false);
        userDefinedCheckBox.setChecked(false);
    }

}
