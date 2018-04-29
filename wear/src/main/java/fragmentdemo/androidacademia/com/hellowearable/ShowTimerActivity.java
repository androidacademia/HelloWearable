package fragmentdemo.androidacademia.com.hellowearable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.wear.widget.CircularProgressLayout;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageView;

public class ShowTimerActivity extends WearableActivity implements CircularProgressLayout.OnTimerFinishedListener {
    private CircularProgressLayout circularProgressLayout;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_timer);
        circularProgressLayout = findViewById(R.id.circularProgressLayout);
        imageView = findViewById(R.id.imageView);
        // Enables Always-on
        setAmbientEnabled();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowTimerActivity.this, ConfirmationActivity.class);
                intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                        ConfirmationActivity.FAILURE_ANIMATION);
                intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,"NOT saved");
                startActivity(intent);
            }
        });
    }

    public void showConfirmation(View view) {
        circularProgressLayout.setVisibility(View.VISIBLE);
        circularProgressLayout.setOnTimerFinishedListener(this);
        circularProgressLayout.setTotalTime(3000);
        circularProgressLayout.startTimer();
    }

    @Override
    public void onTimerFinished(CircularProgressLayout layout) {
        circularProgressLayout.setVisibility(View.GONE);
        Intent intent = new Intent(this, ConfirmationActivity.class);
        intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,ConfirmationActivity.SUCCESS_ANIMATION);
        intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,"Saved");
        startActivity(intent);
    }
}
