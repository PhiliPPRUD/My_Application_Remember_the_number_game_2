package my.application.myapplicationrememberthenumbergame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView info;
    private EditText user_field;
    private Button main_btn;
    private TextView result_info;
    private int vvodInt;
    private int rInt;
    private Button further_btn;
    private int seconds;
    private Button level_btn1;
    private Button level_btn2;
    private Button level_btn3;
    private int numberMAX;
    private int numberMIN;
    private Button seconds_settings_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.info);
        user_field = findViewById(R.id.user_field);
        main_btn = findViewById(R.id.main_btn);
        result_info = findViewById(R.id.result_info);
        further_btn = findViewById(R.id.further_btn);
        seconds = 2;
        level_btn1 = findViewById(R.id.level_btn1);
        level_btn2 = findViewById(R.id.level_btn2);
        level_btn3 = findViewById(R.id.level_btn3);
        seconds_settings_btn = findViewById(R.id.seconds_settings_btn);



        View.OnClickListener oclseconds_settings_btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        };

        seconds_settings_btn.setOnClickListener(oclseconds_settings_btn);



        level_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberMAX = 9999;
                numberMIN = 1000;

            }
        });
        level_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberMAX = 99999;
                numberMIN = 10000;

            }
        });
        level_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberMAX = 999999;
                numberMIN = 100000;

            }
        });



        further_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (numberMIN==0) {
                    Toast.makeText(MainActivity.this, R.string.no_user_input1, Toast.LENGTH_LONG).show();
                }


                rInt = (int) ((Math.random() * ((numberMAX-numberMIN)+1))+numberMAX);
                info.setText(Integer.toString(rInt));

                CountDownTimer my_timer = new CountDownTimer(seconds*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        info.setText(Integer.toString(rInt));
                    }

                    @Override
                    public void onFinish() {
                        info.setText("");
                    }

                };
                my_timer.start();

            }
        });


        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user_field.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, R.string.no_user_input, Toast.LENGTH_LONG).show();
                }
                else {
                    vvodInt = Integer.parseInt(user_field.getText().toString());
                    if (rInt == vvodInt) {
                        result_info.setText("Верно");
                        user_field.setText("");
                    } else {
                        result_info.setText("Неверно");
                    }
                }
            }
        });
    }
}