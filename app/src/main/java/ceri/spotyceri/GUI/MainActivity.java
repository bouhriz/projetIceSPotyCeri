package ceri.spotyceri.GUI;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import ceri.spotyceri.GUI.androidGUI.R;

public class MainActivity extends Activity {
    private Button btnPress;
    private boolean btnplayPause =false;
    private boolean isVolumeStop = false ;
    private SeekBar seekBar;
    private ImageView imgeView;
    private Button bntSpeech;
    private Button btnSound;
    private static final int RECOGNIZER_RESULT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_music);
        btnPress = findViewById(R.id.btnpress);
        seekBar = (SeekBar) findViewById(R.id.seekkbar);
        imgeView = findViewById(R.id.imgeView);
        bntSpeech = findViewById(R.id.bntSpeech);
        btnSound = findViewById(R.id.bntSound);

        // button play or stop music
        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnplayPause) {
                    btnPress.setBackgroundResource(R.drawable.ic_play);
                    imgeView.setBackgroundResource(R.drawable.equalazir_stoped);
                    btnplayPause = false;
                }
                else{
                    btnPress.setBackgroundResource(R.drawable.ic_pause);
                    imgeView.setBackgroundResource(R.drawable.equalazir_runing);
                    btnplayPause = true;
                }

            }
        });

        // Button play or stop the sound
              btnSound.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isVolumeStop) {
                    btnSound.setBackgroundResource(R.drawable.ic_volum_off2);
                    isVolumeStop =true;
                }
                else {
                    btnSound.setBackgroundResource(R.drawable.ic_volume);
                    isVolumeStop =false;
                }
            }
        });

        // button google speach
        bntSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Parlez maintenant!");
                try{
                    startActivityForResult(intent, RECOGNIZER_RESULT);
                } catch (ActivityNotFoundException e ) {
                    Toast.makeText(getApplicationContext(), "vote téléphone ne support pas google speach", Toast.LENGTH_SHORT);

                    e.printStackTrace();

                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_read_track, menu);
        getActionBar().setIcon(R.drawable.ic_read_48);
        return true;
    }
}

