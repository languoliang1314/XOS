package com.xrross.xoscn;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.xrross.solutionprovider.fragment.FeiShiFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
        setContentView(R.layout.activity_main);
        WindowManager wmanager = this.getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        wmanager.getDefaultDisplay().getMetrics(dm);
        int widthPixels2 = dm.widthPixels;
        int heightPixels2 = dm.heightPixels;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment,new FeiShiFragment()).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
