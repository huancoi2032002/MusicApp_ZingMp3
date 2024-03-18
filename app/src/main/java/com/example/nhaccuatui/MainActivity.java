package com.example.nhaccuatui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.example.nhaccuatui.Adapter.ViewPagerAdapter;
import com.example.nhaccuatui.Fragment.AlbumFragment;
import com.example.nhaccuatui.Fragment.DiscoveryFragment;
import com.example.nhaccuatui.Fragment.PlayFragment;
import com.example.nhaccuatui.Fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView navigationView;

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_paper);
        navigationView = findViewById(R.id.nav_bar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2); //Mac dinh la` 1, khi la` 2 thi` se truyen 2 page

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationView.getMenu().findItem(R.id.id_play).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.id_discovery).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.id_album).setChecked(true);
                        break;
                    case 3:
                        navigationView.getMenu().findItem(R.id.id_user).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();
                if(itemID == R.id.id_play){
                    viewPager.setCurrentItem(0);
                    PlayFragment playFragment = (PlayFragment) viewPager.getAdapter().instantiateItem(viewPager, 0);
                    playFragment.reloadData();
                    return false;
                }else if (itemID == R.id.id_discovery){
                    viewPager.setCurrentItem(1);
                    DiscoveryFragment discoveryFragment = (DiscoveryFragment) viewPager.getAdapter().instantiateItem(viewPager, 1);
                    discoveryFragment.reloadData();
                    return false;
                }
                else if (itemID == R.id.id_album){
                    viewPager.setCurrentItem(2);
                    AlbumFragment albumFragment = (AlbumFragment) viewPager.getAdapter().instantiateItem(viewPager, 2);
                    albumFragment.reloadData();
                    return false;
                }
                else if (itemID == R.id.id_user){
                    viewPager.setCurrentItem(3);
                    UserFragment userFragment = (UserFragment) viewPager.getAdapter().instantiateItem(viewPager, 3);
                    userFragment.reloadData();
                    return false;
                }
                return true;
            }
        });

    }
}