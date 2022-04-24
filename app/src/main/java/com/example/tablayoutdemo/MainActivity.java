package com.example.tablayoutdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //1. initialise variable
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2. asign variable
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        //3. initialise array list
        ArrayList<String> arrayList = new ArrayList<>();
        //4. add Tab tiles in array list
        arrayList.add("Tab 1");
        arrayList.add("Tab 2");
        arrayList.add("Tab 3");
        arrayList.add("Tab 4");

        //4. prepare ViewPager
        prepareViewPager(viewPager,arrayList);
        //21. Setup with view pager
        tabLayout.setupWithViewPager(viewPager);
        //22. goto String.xml change to NoActionBar
        //23. Click build APK


    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        //5. Initialise MainAdapter
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        //13. initialise mainfragment //add MainFargment // initialise view and corerct the textview in xml then come back here
        MainFragment fragment = new MainFragment();
        //14. Use For loop
        for (int i = 0; i<arrayList.size(); i++){

            //15 ibnitialise bundle
            Bundle bundle = new Bundle();
            //16. put string
            bundle.putString("title", arrayList.get(i));
            //17. Set argument
            fragment.setArguments(bundle);
            //18 add fragments
            adapter.addFragment(fragment,arrayList.get(i));
            //19. Define new fragment
            fragment = new MainFragment();

        }

        //20. set adapter
        viewPager.setAdapter(adapter);

    }


    private class MainAdapter extends FragmentPagerAdapter {

        //6. Initialise arra list
        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();

        //7. create constructor

        public void addFragment(Fragment fragment, String title){
            //8. add title
            arrayList.add(title);
            //9.add Fragment
            fragmentList.add(fragment);
        }
        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //10. return fragment position
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            //11 return fragment list size
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //12 return array list postion
            return arrayList.get(position);



        }

    }
}