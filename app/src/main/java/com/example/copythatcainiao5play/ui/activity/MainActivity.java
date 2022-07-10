package com.example.copythatcainiao5play.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.copythatcainiao5play.R;
import com.example.copythatcainiao5play.di.component.AppComponent;
import com.example.copythatcainiao5play.ui.adapter.ViewPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    String TAG="MainActivity";
    
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.navigation_view)
    NavigationView mNavigation;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setUpActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void init() {
        initDrawerLayout();

        initTabLayout();
    }

    private void initDrawerLayout(){
        headerView=mNavigation.getHeaderView(0);

        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"headerView click",Toast.LENGTH_SHORT).show();
            }
        });

        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_app_updata:
                        Toast.makeText(MainActivity.this,"menu_app_updata",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(MainActivity.this,"menu_setting",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_other:
                        Toast.makeText(MainActivity.this,"menu_other",Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

        mToolBar.inflateMenu(R.menu.toolbar_menu);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,dlMain,mToolBar,R.string.open,R.string.close);

        drawerToggle.syncState();

        dlMain.addDrawerListener(drawerToggle);
    }

    private void initTabLayout(){

        PagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        }
}
