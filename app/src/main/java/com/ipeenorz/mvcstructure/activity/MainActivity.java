package com.ipeenorz.mvcstructure.activity;


import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ipeenorz.mvcstructure.R;
import com.ipeenorz.mvcstructure.fragment.MainFragment;
import com.ipeenorz.mvcstructure.fragment.SecondFragment;
import com.ipeenorz.mvcstructure.util.ScreenUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtil.getInstance().getScreenWidth();
        int screenHeight = ScreenUtil.getInstance().getScreenHeight();

        Toast toast = Toast.makeText(getApplicationContext(), "Width" + screenWidth + "Height" + screenHeight, Toast.LENGTH_LONG);
        toast.show();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(123),
                            "mainFragment")
                    .commit();


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.action_SecondFragment){

            Toast.makeText(MainActivity.this ,"Second Fragment",Toast.LENGTH_LONG).show();

            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if(fragment instanceof SecondFragment==false){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentContainer, SecondFragment.newInstance())
                    .addToBackStack(null)
                    .commit();}
            return true;




        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(savedInstanceState==null){
            MainFragment fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("mainFragment");
            fragment.setHelloText("Wooo  hooooo");

        }
    }
}
