package com.rhmn.arz.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.rhmn.arz.databinding.ActivityHomeBinding;
import com.rhmn.arz.R;

public class Home extends AppCompatActivity {

    public TabLayout tabLayout;
    public FrameLayout frameLayout;
    FragmentTransaction ft;
    public TabItem home,market;
    NavController navController;
    private ActivityHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        tabLayout = findViewById(R.id.tab_layout);
//        home = findViewById(R.id.home_tab);

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.frame_home, new HomeFr()).commit();


//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                int x = tabLayout.getSelectedTabPosition();
//                selectPage(x);
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        ///navigatin bar
//        BottomNavigationView navView = findViewById(R.id.tab_layout);
        navController = Navigation.findNavController(Home.this, R.id.frame_home);
        NavigationUI.setupWithNavController(binding.tabLayout, navController);

    }
//    public void selectPage(int pageIndex){
//        tabLayout.setScrollPosition(pageIndex,0f,true);
//
//        switch (pageIndex){
//            case 0:
//                ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frame_home, new HomeFr());
//                ft.commit();
//                break;
//            case 1:
//                ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frame_home, new MarketFr());
//                ft.commit();
//                break;
//            case 2:
//                ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frame_home, new ProfileFr());
//                ft.commit();
//                break;
//
//        }
//
//    }
}