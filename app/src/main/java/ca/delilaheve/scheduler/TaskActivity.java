package ca.delilaheve.scheduler;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import ca.delilaheve.scheduler.data.Task;
import ca.delilaheve.scheduler.fragment.EditTaskFragment;
import ca.delilaheve.scheduler.fragment.ViewTaskFragment;
import ca.delilaheve.scheduler.util.Keys;

public class TaskActivity extends AppCompatActivity {

    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Fragment fragment;
        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            task = (Task) extras.getSerializable(Keys.TASK);

            switch (extras.getString(Keys.VIEW_MODE)) {
                case Keys.EDIT:
                    fragment = new EditTaskFragment();
                    break;
                case Keys.VIEW:
                default:
                    fragment = new ViewTaskFragment();
                    break;
            }

            Bundle args = new Bundle();
            args.putSerializable(Keys.TASK, task);
            fragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment).commit();
        }
    }

    private void setViewMode(String viewMode) {
        Fragment fragment = null;

        switch (viewMode) {
            case Keys.VIEW:
                fragment = new ViewTaskFragment();
                break;
            case Keys.EDIT:
                fragment = new EditTaskFragment();
                break;
        }

        if(fragment != null) {
            int slideIn, slideOut;
            slideIn = R.anim.slide_in;
            slideOut = R.anim.slide_out;

            Bundle args = new Bundle();
            args.putSerializable(Keys.TASK, task);
            fragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(slideIn, slideOut, slideIn, slideOut);
            transaction.replace(R.id.container, fragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }

        return false;
    }
}
