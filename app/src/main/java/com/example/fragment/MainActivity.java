package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.mytv);
        iv = findViewById(R.id.imageMenu);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(MainActivity.this,view);
                p.inflate(R.menu.menu_fragment);
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.menu1) {
                            replaceFragment(new Fragment1(),"Fragment 1");
                        } else if (id ==R.id.menu2) {
                            replaceFragment(new Fragment2(),"Fragment 2");
                        } else if (id==R.id.menuA) {
                            replaceFragment(new FragmentA(),"Fragment A");
                        }
                        return true;
                    }
                });
                p.show();
            }
        });
    }

    private void replaceFragment(Fragment fragment, String title) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layoutFragment,fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();


    }
}