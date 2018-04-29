package fragmentdemo.androidacademia.com.hellowearable;

import android.os.Bundle;
import android.support.wear.widget.WearableLinearLayoutManager;
import android.support.wear.widget.WearableRecyclerView;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableListView;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private WearableRecyclerView wearableListView;
    private String[] dayList = {"Sunday","Monday","Tuesday","Wednesday",
                "Thrusday","Friday","Saturday"};
    private MyWearableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wearableListView = findViewById(R.id.recycler_launcher_view);
        wearableListView.setEdgeItemsCenteringEnabled(true);
        wearableListView.setLayoutManager(new WearableLinearLayoutManager(this));
        adapter = new MyWearableAdapter(this,dayList);
        wearableListView.setAdapter(adapter);


        // Enables Always-on
        setAmbientEnabled();
    }
}
