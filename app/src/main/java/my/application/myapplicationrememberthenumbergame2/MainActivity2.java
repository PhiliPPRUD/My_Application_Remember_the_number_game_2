package my.application.myapplicationrememberthenumbergame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private Button back_btn;
    private EditText vvod_secText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        back_btn = findViewById(R.id.back_btn);
        vvod_secText = findViewById(R.id.vvod_sec);

        View.OnClickListener oclback_btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);

            }
        };
        back_btn.setOnClickListener(oclback_btn);
    }
    public void sendDate(View view) {
        int vvod_sec = Integer.parseInt(vvod_secText.getText().toString());
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra("pass", vvod_sec);
        startActivity(intent);
    }
}