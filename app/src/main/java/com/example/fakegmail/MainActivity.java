package com.example.fakegmail;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fakegmail.databinding.ActivityMainBinding;
import com.example.fakegmail.fragment.eyoelseleshizeyohannes;
import com.example.fakegmail.fragment.forsomesuswebs;
import com.example.fakegmail.fragment.joelthousend;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationBarView.OnItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    ImageButton menu;

    Dialog dialog;
    ImageButton getOutDialog;
    CircleImageView pickAccount;
    CircleImageView joelthousendOpen;
    CircleImageView eyoelselshiOpne;
    CircleImageView forsuswebsOpen;
    BottomNavigationView bottom;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pickAccount=findViewById(R.id.pick_account);
        bottom=findViewById(R.id.bottoms);

        //setSupportActionBar(binding.appBarMain.toolbar);
        menu=findViewById(R.id.nav_drawer);

        dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_account_pick);
        dialog.getWindow().setBackgroundDrawable(getDrawable( R.drawable.round_card));
        dialog.setCancelable(true);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);


        getOutDialog=dialog.findViewById(R.id.back_to);
        joelthousendOpen=dialog.findViewById(R.id.joelthousend_open);
        eyoelselshiOpne=dialog.findViewById(R.id.eyoelseleshi_open);
        forsuswebsOpen=dialog.findViewById(R.id.forsuswebs_open);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);

        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,new joelthousend(),null).commit();
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawer.isOpen()){
                    drawer.close();
                }else {
                    drawer.open();
                }
            }
        });

        getOutDialog.setOnClickListener(this);
        joelthousendOpen.setOnClickListener(this);
        eyoelselshiOpne.setOnClickListener(this);
        forsuswebsOpen.setOnClickListener(this);
        bottom.setOnItemSelectedListener(this);
        pickAccount.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.joelthousend_open){
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,new joelthousend(),null).commit();
            dialog.dismiss();
            pickAccount.setImageDrawable(getDrawable( R.drawable.joelaccount));
        }else if(v.getId()==R.id.eyoelseleshi_open){
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,new eyoelseleshizeyohannes(),null).commit();
            dialog.dismiss();
            pickAccount.setImageDrawable(getDrawable( R.drawable.eyoelseleshizeyohannes));
        }else if(v.getId()==R.id.forsuswebs_open){
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,new forsomesuswebs(),null).commit();
            dialog.dismiss();
            pickAccount.setImageDrawable(getDrawable( R.drawable.forsusaccount));
        }else if(v.getId()==R.id.pick_account){
            dialog.show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.meeting){
            Intent i=new Intent(getApplicationContext(),meeting.class);
            startActivity(i);
            return  true;
        }else if(id==R.id.account_page){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            return true;
        }
        return false;
    }
}