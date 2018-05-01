package com.example.a2lavea02.solenteatout;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Preference extends PreferenceActivity{

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }

    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        boolean isRecording = false;
        savedInstanceState.putBoolean("isRecording", isRecording);
    }

    public void onDestroy()
    {
        boolean isRecording = false;
        super.onDestroy();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isRecording", isRecording);
        editor.commit();
    }
}
