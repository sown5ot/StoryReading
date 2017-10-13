package sonhoang.vn.storyreading.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sonhoang.vn.storyreading.R;
import sonhoang.vn.storyreading.databases.StoryModel;

/**
 * Created by Son Hoang on 10/7/2017.
 */

public class StoryAdapter extends ArrayAdapter<StoryModel> {
    private Context context;
    private int resource;
    private List<StoryModel> storyModels;

    public StoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<StoryModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.storyModels = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //setUI
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        View vBookmark = convertView.findViewById(R.id.v_bookmark);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title_story);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tv_author_story);
        ImageView ivImageStory = (ImageView) convertView.findViewById(R.id.iv_image_story);

        //setData
        if (!storyModels.get(position).isBookmark()){
            vBookmark.setBackgroundResource(R.color.colorPrimary);
        } else {
            vBookmark.setBackgroundResource(R.color.colorAccent);
        }
        tvTitle.setText(storyModels.get(position).getTitle());
        tvAuthor.setText(storyModels.get(position).getAuthor());

        //decode image base64
        String[] base64 = storyModels.get(position).getImage().split(",");
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                Base64.decode(base64[1], Base64.DEFAULT),
                0,
                Base64.decode(base64[1], Base64.DEFAULT).length
        );
        ivImageStory.setImageBitmap(bitmap);

        return convertView;
    }
}
