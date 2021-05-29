package com.taskfoundation.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = this.getSharedPreferences("com.taskfoundation.sharedpreferences", Context.MODE_PRIVATE);

        /**
         * save and get a String.
         */
        preferences.edit().putString("username", "HAMZA").apply();

        String username = preferences.getString("username", "");

        Log.i("username: ", username);
        /**
         * END SAVE STRING.
         */

        //---------------------------//
        /**
         * save and get a Array List.
         */
        ArrayList<String> friends = new ArrayList<String>();
        friends.add("Ahmad");
        friends.add("Saif");
        friends.add("Amer");

        try {
            preferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();

            Log.i("friends", ObjectSerializer.serialize(friends));


            ArrayList<String> newFriends = new ArrayList<String>();

            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(preferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));

            Log.i("newFriends: ", newFriends.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * END SAVE ARRAY LIST.
         */

    }
}