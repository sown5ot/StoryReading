package sonhoang.vn.storyreading.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sonhoang.vn.storyreading.databases.DatabaseHandle;
import sonhoang.vn.storyreading.R;
import sonhoang.vn.storyreading.adapters.StoryAdapter;
import sonhoang.vn.storyreading.databases.StoryModel;

public class MainActivity extends AppCompatActivity {
    public static final String STORY_KEY = "story_key";
    private List<StoryModel> storyModelList = new ArrayList<>();
    private ListView lvStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

    }

    private void setupUI() {
        lvStory = (ListView) findViewById(R.id.lv_story_list);
        storyModelList = DatabaseHandle.getInstance(this).getListStory();
        StoryAdapter storyAdapter = new StoryAdapter(this,
                R.layout.item_list_story,
                storyModelList);
        lvStory.setAdapter(storyAdapter);

        lvStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra(STORY_KEY,
                        storyModelList.get(position));
                startActivity(intent);
            }
        });
    }
}
