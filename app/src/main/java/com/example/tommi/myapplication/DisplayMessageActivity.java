package com.example.tommi.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Hashtable;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView2);


        AlphabetCrypto aakkoset = new AlphabetCrypto();
        Hashtable<Character,Character> krypto = aakkoset.CreateAlphabetTable();
        System.out.println(krypto.toString());

        // Get message from intent, encrypt and set to textview
        String cryptedMessage = "";
        for(char c : message.toCharArray()){
            if(krypto.containsKey(c))
                cryptedMessage += krypto.get(c).toString();
            else
                cryptedMessage += c;
        }
        textView.setText(cryptedMessage);

        // test tablelayout
        int maxLettersPerRow = 10;
        TableLayout tl = (TableLayout) findViewById(R.id.buttonlayout);
        TableLayout.LayoutParams lp = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));

        //////
        // jaa dpn mukaan riville x kappaletta nappeja ja rivitä sanat sen jälkeen
        //////


        for(char c : cryptedMessage.toCharArray()) {
                // Create buttons for text in the row
                Button encryptedTextButton = new Button(this);
                encryptedTextButton.setText(c + "");
                TableRow.LayoutParams buttonlp = new TableRow.LayoutParams(100,TableRow.LayoutParams.WRAP_CONTENT);
                //encryptedTextButton.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                encryptedTextButton.setLayoutParams(buttonlp);
                //add button to tablerow
                tr.addView(encryptedTextButton);
        }
        //add row to tablelayout
        tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));


        /* old test with linearlayout
        for(int i =0;i<3;i++) {
            // Create buttons for text
            Button encryptedTextButton = new Button(this);
            LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(encryptedTextButton, lp);

        }*/
    }
}
