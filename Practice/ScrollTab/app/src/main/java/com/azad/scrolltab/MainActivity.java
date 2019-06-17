package com.azad.scrolltab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {
private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager) findViewById(R.id.pagerId);

FragmentManager fragmentManager=getSupportFragmentManager();
        CustomAdapter adapter=new CustomAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
    }
}



class CustomAdapter extends FragmentStatePagerAdapter{

    public CustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
            fragment=new Fragment1();
        }else if(position==0){
            fragment=new Fragment2();
        } else if(position==0){
            fragment=new Fragment3();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}