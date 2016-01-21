package ca.delilaheve.tools.asynctask.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import ca.delilaheve.tools.asynctask.AsyncTask;
import ca.delilaheve.tools.asynctask.AsyncTaskImplementer;

public class AsyncFileRetriever extends AsyncTask {

    private InputStream inputStream;

    private URL url;

    public AsyncFileRetriever(URL url, AsyncTaskImplementer implementer, String taskId) {
        super(taskId, implementer);
        this.url = url;
    }

    @Override
    public void run() {
        try {
            inputStream = new BufferedInputStream(url.openStream());
            taskCompleted();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
