package com.example.nhaccuatui.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.nhaccuatui.Fragment.AlbumFragment;
import com.example.nhaccuatui.Fragment.DiscoveryFragment;
import com.example.nhaccuatui.Fragment.PlayFragment;
import com.example.nhaccuatui.Fragment.UserFragment;

import org.jetbrains.annotations.NonNls;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PlayFragment();
            case 1:
                return new DiscoveryFragment();
            case 2:
                return new AlbumFragment();
            case 3:
                return new UserFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4; //return 4 tab
    }
}
