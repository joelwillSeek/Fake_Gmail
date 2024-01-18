package com.example.fakegmail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import de.hdodenhof.circleimageview.CircleImageView;

public class meeting extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener,View.OnClickListener {

    BottomNavigationView bottom;
    CircleImageView pickAccount;
    Dialog dialog;
    ImageButton getOutDialog;
    CircleImageView joelthousendOpen;
    CircleImageView eyoelselshiOpne;
    CircleImageView forsuswebsOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);
        bottom=findViewById(R.id.bottoms);
        pickAccount=findViewById(R.id.pick_account2);

        bottom.setOnItemSelectedListener(this);
        pickAccount.setOnClickListener(this);

        dialog=new Dialog(meeting.this);
        dialog.setContentView(R.layout.dialog_account_pick);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.round_card));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        getOutDialog=dialog.findViewById(R.id.back_to);
        joelthousendOpen=dialog.findViewById(R.id.joelthousend_open);
        eyoelselshiOpne=dialog.findViewById(R.id.eyoelseleshi_open);
        forsuswebsOpen=dialog.findViewById(R.id.forsuswebs_open);

        getOutDialog.setOnClickListener(this);
        joelthousendOpen.setOnClickListener(this);
        eyoelselshiOpne.setOnClickListener(this);
        forsuswebsOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.pick_account2){
            dialog.show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

       if(id==R.id.account_page){
            finish();
            return true;
        }
        return false;
    }
}