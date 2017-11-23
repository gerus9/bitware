package com.gerus.bitware.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.gerus.bitware.R;
import com.gerus.bitware.interfaces.activities.OnMenuActivityInterface;
import com.gerus.bitware.views.fragments.PersonFragment;
import com.gerus.bitware.views.fragments.RequestsFragment;

/**
 * Created by gerus-mac on 22/01/17.
 */

public class MenuActivity extends AppCompatActivity implements OnMenuActivityInterface {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mContext = this;

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment voFragment = null;
                switch (item.getItemId()){
                    case R.id.menu_persons:
                        voFragment = new PersonFragment();
                        break;
                    case R.id.menu_requests:
                        voFragment = new RequestsFragment();
                        break;
                }
                prcChangeFragment(voFragment);
                return true;
            }
        });
        bottomNavigationView.findViewById(R.id.menu_persons).performClick();
    }

    private void prcChangeFragment(Fragment poFragment) {
        if(poFragment!=null) getSupportFragmentManager().beginTransaction().replace(R.id.fragments, poFragment).commit();
    }

    @Override
    public void changeTitle(int idString) {
        setTitle(idString);
    }
}
