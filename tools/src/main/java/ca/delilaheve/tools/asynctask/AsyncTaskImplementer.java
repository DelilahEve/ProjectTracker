package ca.delilaheve.tools.asynctask;

import android.app.Activity;

public interface AsyncTaskImplementer {

    void onTaskComplete(String taskId);

    Activity getCurrentActivity();

}
