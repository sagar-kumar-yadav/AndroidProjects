package com.example.android.miwokapp;

public class Word {

    // default translate for the word
    private String mDefaultTranslation;

    // Miwok translation fr the word
    private String mMiwokTranslation;

    public Word(String DefaultTranslation, String MiwokTranslation) {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
    }

    // get the default translation of the word
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    // get the miwok translation of the word
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }
}