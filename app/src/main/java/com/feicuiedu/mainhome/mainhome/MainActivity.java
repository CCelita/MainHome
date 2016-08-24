package com.feicuiedu.mainhome.mainhome;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    private HotRepoFragment hotRepoFragment;
    private HotUserFragment hotUserFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hotRepoFragment = new HotRepoFragment();
        replaceFragment(hotRepoFragment);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    @Override public boolean onNavigationItemSelected(MenuItem item) {

        if (item.isChecked()){
            item.setChecked(false);
        }
        switch (item.getItemId()){
            //热门仓库
            case R.id.github_hot_repo:
                replaceFragment(hotRepoFragment);
                break;
            //开发者
            case R.id.github_hot_coder:
                if (hotUserFragment==null){
                    hotUserFragment = new HotUserFragment();
                }
                replaceFragment(hotUserFragment);
                break;

            //收藏
             case R.id.arsenal_my_repo:
                Toast.makeText(this,"我的Dota",Toast.LENGTH_SHORT).show();
                break;

             //每日干货
            case R.id.tips_daily:
                Toast.makeText(this,"我的Dota",Toast.LENGTH_SHORT).show();
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
