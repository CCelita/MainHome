package com.feicuiedu.mainhome.mainhome;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigationview);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.book5:
                Toast.makeText(this,"我的LOL",Toast.LENGTH_SHORT).show();
                break;
            case R.id.book6:
                Toast.makeText(this,"我的Dota",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
