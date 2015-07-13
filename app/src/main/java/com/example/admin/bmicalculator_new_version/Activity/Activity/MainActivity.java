package com.example.admin.bmicalculator_new_version.Activity.Activity;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.View;

import com.example.admin.bmicalculator_new_version.R;
import com.example.admin.bmicalculator_new_version.Activity.Activity.Fragment.*;


public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment main = new MainFragment();

        ft.replace(R.id.activity_container, main);
        ft.commit();
    }

    public void onClickNext(View view) {
        setContentView(R.layout.fragment_sub);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment next = new MainFragment();

        ft.addToBackStack(null);
        ft.replace(R.id.sub_container, next);
        ft.commit();
    }

    public void onClickReturn(View v){
        setContentView(R.layout.fragment_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment next = new SubFragment();

        ft.addToBackStack(null);
        ft.replace(R.id.main_container, next);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.fragment_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment back = new SubFragment();

        ft.replace(R.id.main_container, back);
        ft.commit();

        int backStackCnt = getFragmentManager().getBackStackEntryCount();

        if (backStackCnt != 0) {
            getFragmentManager().popBackStack();
        }
    }
}
