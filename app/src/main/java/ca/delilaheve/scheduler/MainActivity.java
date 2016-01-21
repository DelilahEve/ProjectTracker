package ca.delilaheve.scheduler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton action;
    private FloatingActionButton smallFab;

    private TextView projectText;
    private TextView taskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(smallFab.getVisibility() == View.GONE) {
                    showButtons();
                }
                else {
                    hideButtons();
                }
            }
        });

        smallFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideButtons();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initialize(){
        action = (FloatingActionButton) findViewById(R.id.fab);
        smallFab = (FloatingActionButton) findViewById(R.id.smallfab);

        projectText = (TextView) findViewById(R.id.addProjectText);
        taskText = (TextView) findViewById(R.id.addTaskText);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showButtons(){
        smallFab.setVisibility(View.VISIBLE);
        projectText.setVisibility(View.VISIBLE);
        taskText.setVisibility(View.VISIBLE);
    }

    private void hideButtons(){
        smallFab.setVisibility(View.GONE);
        projectText.setVisibility(View.GONE);
        taskText.setVisibility(View.GONE);
    }
}
