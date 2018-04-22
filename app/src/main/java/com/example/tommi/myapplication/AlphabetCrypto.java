package com.example.tommi.myapplication;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class AlphabetCrypto {
private static int NUM_ALPHABET = 26; //aakkosten maara

    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private List<Character> alphabetRandomizerList = new ArrayList<>();

    public Hashtable<Character,Character> CreateAlphabetTable(){


        Random randomGenerator = new Random();
        Hashtable<Character,Character> alphabetTable = new Hashtable<Character, Character>();

        // Clear and set up random list of chars
        alphabetRandomizerList.clear();
        for (char c : alphabet) {
            alphabetRandomizerList.add(c);
        }
        Collections.shuffle(alphabetRandomizerList);
        Log.d("MyApp","I am here");
        for(int i = 0; i<alphabet.length;i++) {

            alphabetTable.put(alphabet[i],alphabetRandomizerList.get(i));

        }
        return alphabetTable;
    }


}

