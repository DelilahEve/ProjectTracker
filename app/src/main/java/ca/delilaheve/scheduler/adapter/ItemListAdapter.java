package ca.delilaheve.scheduler.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ca.delilaheve.scheduler.R;
import ca.delilaheve.scheduler.TaskActivity;
import ca.delilaheve.scheduler.data.Task;
import ca.delilaheve.scheduler.util.Keys;

public class ItemListAdapter extends BaseAdapter {

    private ArrayList<Task> tasks;

    private Context context;

    public ItemListAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_contact, (ViewGroup) convertView, false);

        TextView title = (TextView) view.findViewById(R.id.taskTitle);
        ImageView editButton = (ImageView) view.findViewById(R.id.editTaskIcon);

        // set title text
        title.setText("");

        // set edit button click
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // edit task
                Intent i = new Intent(context, TaskActivity.class);
                i.putExtra(Keys.VIEW_MODE, Keys.EDIT);
                context.startActivity(i);
            }
        });

        // set card click event
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TaskActivity.class);
                i.putExtra(Keys.VIEW_MODE, Keys.VIEW);
                context.startActivity(i);
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
