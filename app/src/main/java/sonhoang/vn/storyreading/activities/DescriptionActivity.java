package sonhoang.vn.storyreading.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import sonhoang.vn.storyreading.R;
import sonhoang.vn.storyreading.databases.AssetHelper;
import sonhoang.vn.storyreading.databases.StoryModel;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = DescriptionActivity.class.toString();
    private ImageView ivBackButton;
    private ImageView ivBookmarkButton;
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvDescription;
    private Button btStartReading;
    private int storyID;
    private StoryModel storyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

    }

    private void loadData() {
        storyModel = (StoryModel) getIntent().getSerializableExtra(MainActivity.STORY_KEY);
        String[] base64 = storyModel.getImage().split(",");
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                Base64.decode(base64[1], Base64.DEFAULT),
                0,
                Base64.decode(base64[1], Base64.DEFAULT).length
        );
        ivImage.setImageBitmap(bitmap);
        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());
        tvDescription.setText(storyModel.getDescription());
        storyID = storyModel.getId();
        if (!storyModel.isBookmark()){
            ivBookmarkButton.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
        } else {
            ivBookmarkButton.setImageResource(R.drawable.ic_bookmark_black_24dp);
        }
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
        tvTitle = (TextView) findViewById(R.id.tv_story_title);
        tvAuthor = (TextView) findViewById(R.id.tv_story_author);
        tvDescription = (TextView) findViewById(R.id.tv_story_description);
        btStartReading = (Button) findViewById(R.id.bt_start_reading);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_button:{
                //default back button
                super.onBackPressed();
                break;
            }

            case R.id.iv_bookmark_button:{
                Log.d(TAG, "onClick: bookmark");
                updateBookmark();
                break;
            }

            case R.id.bt_start_reading:{
                Log.d(TAG, "onClick: start");
                break;
            }
        }
    }

    private void updateBookmark() {
        boolean storyBookmark = storyModel.isBookmark();
        AssetHelper assetHelper = new AssetHelper(this);
        SQLiteDatabase sqLiteDatabase = assetHelper.getWritableDatabase();
        if (!storyBookmark) {
            sqLiteDatabase.execSQL("update tbl_short_story set bookmark = 1 where id = " + storyID);
            ivBookmarkButton.setImageResource(R.drawable.ic_bookmark_black_24dp);
            Log.d(TAG, "updateBookmark: bookmarked");
        } else {
            sqLiteDatabase.execSQL("update tbl_short_story set bookmark = 0 where id = " + storyID);
            ivBookmarkButton.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
            Log.d(TAG, "updateBookmark: unbookmarked");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        setupUI();
        addListeners();
        loadData();
    }
}
