package sonhoang.vn.storyreading.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import sonhoang.vn.storyreading.R;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = DescriptionActivity.class.toString();
    private ImageView ivBackButton;
    private ImageView ivBookmarkButton;
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvDescription;
    private Button btStartReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        setupUI();
        addListeners();
    }

    private void addListeners() {
        ivBackButton.setOnClickListener(this);
        ivBookmarkButton.setOnClickListener(this);
        btStartReading.setOnClickListener(this);
    }

    private void setupUI() {
        ivBackButton = (ImageView) findViewById(R.id.iv_back_button);
        ivBookmarkButton = (ImageView) findViewById(R.id.iv_bookmark_button);
        ivImage = (ImageView) findViewById(R.id.iv_story_image);
        tvTitle = (TextView) findViewById(R.id.tv_title_story);
        tvAuthor = (TextView) findViewById(R.id.tv_author_story);
        tvDescription = (TextView) findViewById(R.id.tv_story_description);
        btStartReading = (Button) findViewById(R.id.bt_start_reading);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_button:{
                Log.d(TAG, "onClick: back");
                break;
            }

            case R.id.iv_bookmark_button:{
                Log.d(TAG, "onClick: bookmark");
                break;
            }

            case R.id.bt_start_reading:{
                Log.d(TAG, "onClick: start");
                break;
            }
        }
    }
}
