package com.example.tyuumon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tyuumon.fragment.IndexFragment;
import com.example.tyuumon.fragment.MeFragment;
import com.example.tyuumon.fragment.ShoppingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container,new IndexFragment());
        fragmentTransaction.commit();
    }

    public void select_tab(View view){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.index:
                fragmentTransaction.replace(R.id.container,new IndexFragment());
                break;
            case R.id.shopping:
                fragmentTransaction.replace(R.id.container,new ShoppingFragment());
                break;
            case R.id.me:
                fragmentTransaction.replace(R.id.container,new MeFragment());
                break;
            default:
                fragmentTransaction.replace(R.id.container,new IndexFragment());
                break;
        }
        fragmentTransaction.commit();

    }
}