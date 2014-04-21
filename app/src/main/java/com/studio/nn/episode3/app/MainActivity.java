package com.studio.nn.episode3.app;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.studio.nn.episode3.models.PostItem;

import java.util.ArrayList;

/*
* An episode with tab implementation
* */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the tab and set navigation mode to tabs
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);

        // Instantiate the tabs we need and set titles
        android.support.v7.app.ActionBar.Tab friendsTab = actionBar.newTab().setText(R.string.tab_friends);
        android.support.v7.app.ActionBar.Tab allTab = actionBar.newTab().setText(R.string.tab_all);

        // Instantiate the fragments for the tabs
        ListFriendsFeedFragment friendsFragment = ListFriendsFeedFragment.newInstance(new ArrayList<PostItem>());
        ListAllFeedFragment allFragment = ListAllFeedFragment.newInstance(new ArrayList<PostItem>());

        // Implement the tab listeners
        friendsTab.setTabListener(new TabsListener(friendsFragment));
        allTab.setTabListener(new TabsListener(allFragment));

        // Add the tabs to the action bar
        actionBar.addTab(friendsTab);
        actionBar.addTab(allTab);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class TabsListener implements android.support.v7.app.ActionBar.TabListener{
        Fragment fragment;

        public TabsListener(Fragment fragment){
            this.fragment = fragment;
        }

        @Override
        public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            fragmentTransaction.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            fragmentTransaction.remove(fragment);
        }

        @Override
        public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        }
    }

}
