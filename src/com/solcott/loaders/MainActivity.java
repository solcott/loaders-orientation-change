package com.solcott.loaders;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import com.solcott.loaders.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment mainFragment = getFragmentManager().findFragmentById(R.id.main_fragment);
        if(mainFragment == null){
        	Log.w(getClass().getSimpleName(), "creating new Fragment");
        	mainFragment = new MainFragment();
        	getFragmentManager().beginTransaction().add(R.id.main_fragment, mainFragment).commit();
        }
    }
}
