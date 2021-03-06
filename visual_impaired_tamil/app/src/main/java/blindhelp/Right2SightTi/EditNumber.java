package blindhelp.Right2SightTi;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class EditNumber extends ContactSuperClass implements View.OnClickListener{

    GestureDetector gestureDetector;
    private MediaPlayer mediaplayer;
    private static final long DOUBLE_PRESS_INTERVAL = 250; //interval for double press in millis
    long pressTime;
    private long lastPressTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_number);
        getSupportActionBar().hide();// this is the code for the hide applicatoin name
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(400);

        Button1 = (Button) findViewById(R.id.button4);
        Button2 = (Button) findViewById(R.id.button3);
        Button3 = (Button) findViewById(R.id.button2);
        Button4 = (Button) findViewById(R.id.button);

        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);
        Button4.setOnClickListener(this);
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    public void onClick(View v) {
        pressTime = System.currentTimeMillis();
        // If double click...
        if (pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
            resetPlayer();
            switch (v.getId()) {
                case R.id.button4:
                    readContact();
                    //Toast.makeText(getApplicationContext(), "call menu open", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button3:
                    setNumber();
                  //  Toast.makeText(getApplicationContext(), "message menu open", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    SaveName();
                  //  Toast.makeText(getApplicationContext(), "contact open", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button:
                    backToMainMenu();
                  //  Toast.makeText(getApplicationContext(), "reminder open", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else {
            resetPlayer();
            switch (v.getId()) {
                case R.id.button4:break;
                case R.id.button3:break;
                case R.id.button2:break;
                case R.id.button:break;
                case R.id.button1:break;
            }
            lastPressTime = pressTime;
        }
    }

    private void resetPlayer() {
        mediaplayer.release();
    }
    private void backToMainMenu() {
        Intent intent=new Intent(this,EditContact.class);
        startActivity(intent);
        this.finish();
    }

    private void SaveName() {

    }

    private void setNumber() {

    }

    private void readContact() {
        setContact();
        getContact();
    }

}
