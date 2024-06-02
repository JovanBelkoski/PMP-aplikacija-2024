package com.example.recnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            PrintStream zapisi = new PrintStream(openFileOutput("recnikk.txt", MODE_PRIVATE));
            zapisi.println("sample, пример");
            zapisi.println("morning, утро");
            zapisi.println("hello, здраво");
            zapisi.println("trousers, пантолони");
            zapisi.println("father, татко");
            zapisi.println("desk, маса");
            zapisi.println("chair, столица");
            zapisi.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void Klik(View view) {
        EditText tekst = (EditText) findViewById(R.id.tekst2);
        String text = tekst.getText().toString();
        String definicija = Pronajdi(text);
        TextView tekstt = (TextView) findViewById(R.id.tekst1);

        if(definicija!=null)
            tekstt.setText(definicija);
        else
            tekstt.setText("Nema takov zbor!!");
    }

    private String Pronajdi(String text) {
        InputStream input = getResources().openRawResource(R.raw.recnikk);
        Scanner scan = new Scanner(input);

        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] niza = line.split(",");

            if(niza[0].equalsIgnoreCase(text.trim())){
                return niza[1];
            }
        }
        return null;
    }

    public void Kllll(View view) {
        Resources resources = getResources();
        String helloWorldText = resources.getString(R.string.naslov);
    }
}









