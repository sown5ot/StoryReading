package sonhoang.vn.storyreading.databases;

import java.io.Serializable;

/**
 * Created by Son Hoang on 10/7/2017.
 */

public class StoryModel implements Serializable{
    private int id;
    private String image;
    private String title;
    private String description;
    private String content;
    private String author;
    private boolean bookmark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StoryModel(int id, String image, String title, String description, String content, String author, boolean bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "StoryModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", bookmark=" + bookmark +
                '}';
    }
}
