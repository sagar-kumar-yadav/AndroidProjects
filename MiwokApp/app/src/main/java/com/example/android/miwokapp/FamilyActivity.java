package com.example.android.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        //create an array of Words
        ArrayList<Word> words = new ArrayList<Word>();

        //words.add("one");

        //Word w = new Word("one", "lutti");
        //words.add(w);

        words.add(new Word("father", "papa"));
        words.add(new Word("mother", "maa"));
        words.add(new Word("brother", "bhai"));
        words.add(new Word("sister", "behan"));
        words.add(new Word("elder brother", "bada bhai"));
        words.add(new Word("younger brother", "chota bhai"));
        words.add(new Word("elder sister", "badi behan"));
        words.add(new Word("younger sister", "choti behan"));
        words.add(new Word("uncle", "chacha"));
        words.add(new Word("Aunt", "chachi"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}