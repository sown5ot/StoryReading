package sonhoang.vn.storyreading.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Son Hoang on 10/7/2017.
 */

public class DatabaseHandle {
    private static final String TAG = DatabaseHandle.class.toString();
    private AssetHelper assetHelper;
    private SQLiteDatabase sqLiteDatabase;

    private DatabaseHandle(Context context) {
        assetHelper = new AssetHelper(context);
    }

    private static DatabaseHandle databaseHandle;

    public static DatabaseHandle getInstance(Context context){
        if (databaseHandle == null) {
            return databaseHandle = new DatabaseHandle(context);
        } else {
            return databaseHandle;
        }
    }

    public List<StoryModel> getListStory(){
        List<StoryModel> storyModels = new ArrayList<>();
        sqLiteDatabase = assetHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from tbl_short_story", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            //get data
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            boolean bookmark = cursor.getInt(6) != 0;

            StoryModel storyModel = new StoryModel(image, title, description, content, author, bookmark);
            storyModels.add(storyModel);

            //move next
            cursor.moveToNext();
        }

        Log.d(TAG, "getListStory: " + storyModels.size());
        return storyModels;
    }
}
