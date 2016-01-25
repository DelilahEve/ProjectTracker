package ca.delilaheve.scheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import ca.delilaheve.scheduler.fragment.ProjectFeedListFragment;
import ca.delilaheve.scheduler.fragment.ProjectItemListFragment;

public class ProjectActivity extends AppCompatActivity {

    public static String VIEW_MODE = "view_mode";

    public static final int MODE_VIEW = 0;
    public static final int MODE_EDIT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            switch (extras.getInt(VIEW_MODE)) {
                case MODE_VIEW:
                    setContentView(R.layout.activity_project);
                    initProjectView();
                    break;
                case MODE_EDIT:
                    setContentView(R.layout.activity_edit_project);
                    initEditView();
                    break;
            }
        }
    }

    private void initProjectView(){
        // initialize regular project view (ViewPager shit)
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;

                switch (position) {
                    case 0:
                        fragment = new ProjectItemListFragment();
                        break;
                    case 1:
                        fragment = new ProjectFeedListFragment();
                        break;
                    default:
                        fragment = new ProjectItemListFragment();
                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }

    private void initEditView(){
        // initialize edit view (edit a project)
    }
}
