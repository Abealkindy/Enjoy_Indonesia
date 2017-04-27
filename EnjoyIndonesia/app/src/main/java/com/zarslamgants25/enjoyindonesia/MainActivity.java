package com.zarslamgants25.enjoyindonesia;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.zarslamgants25.enjoyindonesia.About.About;
import com.zarslamgants25.enjoyindonesia.Category.Category;
import com.zarslamgants25.enjoyindonesia.ChooseLocation.ChooseLocation;
import com.zarslamgants25.enjoyindonesia.Maps.MapsActivity;
import com.zarslamgants25.enjoyindonesia.News.News;
import com.zarslamgants25.enjoyindonesia.Popular.Popular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Context context = this;

    SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//=======================FRAGMENTtablayoutCODE=====================================================================================
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        addTabs(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_ly);
        tabLayout.setupWithViewPager(viewPager);
//=======================FRAGMENTtablayoutCODE=====================================================================================
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //=======================================SLIDER IMAGE======================================================================
        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        Hash_file_maps.put("Pantai Parangtritis", "http://www.wisataku.id/wp-content/uploads/2016/01/pantai-parangtritis-jogja-indonesia.jpg");
        Hash_file_maps.put("Gunung Semeru", "http://www.naturalsunrisetour.com/wp-content/uploads/2015/09/paket-wisata-gunung-semeru-4-hari-3-malam-800x400.jpg");
        Hash_file_maps.put("Candi Borobudur", "https://upload.wikimedia.org/wikipedia/commons/8/8c/Borobudur-Nothwest-view.jpg");
        Hash_file_maps.put("Rumah Gadang", "http://4.bp.blogspot.com/-_pYVMOyAVek/VZ-M7WxBlWI/AAAAAAAAJQ0/HHAarcjpTio/s1600/IMG_1200.JPG");
        Hash_file_maps.put("Pantai Kuta Bali", "http://balipancatour.com/wp-content/uploads/2012/01/kuta-beach-bali.jpg");

        for (String name : Hash_file_maps.keySet()) {

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);
        //=======================================SLIDER IMAGE======================================================================
    }

    //----------------------------------TABviewCODE------------------------------------------------------------------------
    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Nearby(), "Nearby");
        adapter.addFrag(new Popular(), "Popular");
        adapter.addFrag(new ChooseLocation(), "Choose Location");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    //----------------------------------TABviewCODE------------------------------------------------------------------------
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_nearby) {
//            // Handle the camera action
//        } else if (id == R.id.nav_popular) {
//
//        } else if (id == R.id.nav_choose_location) {
//
//        }
 if (id == R.id.nav_news) {
     Intent news = new Intent(getApplicationContext(), News.class);
     startActivity(news);
//        } else if (id == R.id.nav_share) {
//
//        }
 }else if (id == R.id.nav_about) {
            Intent about = new Intent(getApplicationContext(), About.class);
            startActivity(about);
        } else if (id == R.id.nav_exit) {
     AlertDialog.Builder builder = new AlertDialog.Builder(context);
     builder.setMessage("Apakah kamu ingin keluar ?");
     builder.setCancelable(false);
     builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i) {
             MainActivity.this.finish();
         }
     }).setNegativeButton("Tidak", null).show();
//        } else if (id == R.id.nav_category) {
//            Intent category = new Intent(getApplicationContext(), Category.class);
//            startActivity(category);
//        }
 } else if (id == R.id.nav_maps) {
            Intent map = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(map);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //======================================SLIDER IMAGE=================================================================
    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //======================================SLIDER IMAGE=================================================================
}
