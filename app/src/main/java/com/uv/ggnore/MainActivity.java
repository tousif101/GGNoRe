package com.uv.ggnore;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.codehaus.jackson.smile.Tool;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements HomeFragment.TaskCallbacks, ChampionsFragment.TaskCallbacks {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ListView drawerList;
    private ActionBarDrawerToggle mToggle;
    private ApiWrapper server = new ApiWrapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();
        displayFragment(0);
    }

    private void setup()  {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.drawer_list);

        String[] navigationItems = getResources().getStringArray(R.array.nav_list_titles);
        NavigationAdapter navigationAdapter = new NavigationAdapter(this, navigationItems);
        drawerList.setAdapter(navigationAdapter);
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayFragment(position);
            }
        });
    }

    private void displayFragment(int id)  {
        Fragment fragment = null;
        switch(id)    {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new ChampionsFragment();
                break;
            case 2:
                break;
            default:
                System.out.println("Error: Invalid Fragment id");
        }

        if(fragment != null)    {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }


        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    @Override
    public void onPreExecute() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProgressUpdate(int percent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCancelled() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPostExecute() {
        // TODO Auto-generated method stub

    }
}
