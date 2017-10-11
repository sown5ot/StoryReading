package sonhoang.vn.storyreading.databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Son Hoang on 10/7/2017.
 */

public class AssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "short_story.db";
    private static final int DATABASE_VERSION = 1;

    public AssetHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
