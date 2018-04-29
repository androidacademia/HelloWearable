package fragmentdemo.androidacademia.com.hellowearable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.wear.widget.WearableRecyclerView;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by girishkumarshakya on 29/04/18.
 */

public class MyWearableAdapter extends WearableRecyclerView.Adapter<MyWearableAdapter.MyViewHolder> {
    private String[] dayList;
    private Context context;
    private LayoutInflater inflater;

    public MyWearableAdapter(Context context,String[]dayList){
        this.context = context;
        this.dayList = dayList;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyWearableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyWearableAdapter.MyViewHolder holder, final int position) {
        holder.textView.setText(dayList[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, dayList[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dayList.length;
    }

    public class MyViewHolder extends WearableRecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
