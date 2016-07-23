package com.androiddrac.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CoordinatorLayout   coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "AndroidDRAC SnackBar Tutorial", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btDefault = (Button)findViewById(R.id.defaultSnackbar);
        Button btSnackActionCallBack = (Button)findViewById(R.id.snackBarActionCallback);
        Button btUserDefine = (Button)findViewById(R.id.userDefineColor);

        btDefault.setOnClickListener(new View.OnClickListener(){

            @Override
        public void onClick(View v){

                Snackbar.make(v, "SnackBar Default", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        btSnackActionCallBack.setOnClickListener(new View.OnClickListener(){

            @Override
        public void onClick(View v){

                Snackbar snk = Snackbar.make(coordinatorLayout, "Message Deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener(){
                    @Override
                public void onClick(View v){
                        Snackbar snackbar =
                                Snackbar.make(coordinatorLayout,"Restored Message", Snackbar.LENGTH_LONG);
                    }
                });
                snk.show();
            }
        });

        btUserDefine.setOnClickListener(new View.OnClickListener(){

            @Override
        public  void onClick(View v){
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "AndroidDRAC ", Snackbar.LENGTH_LONG)
                        .setAction("MTK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                // Changing message text color
                snackbar.setActionTextColor(Color.GREEN);

                // Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);

                snackbar.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
