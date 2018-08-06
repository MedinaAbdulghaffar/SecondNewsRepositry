package com.example.nerosoft.assignment;

public class News  {
    private String Author;
    private String Title;
    private String Image;
    String imageBase="https://image.tmdb.org/t/p/w500";


    public News(String author,String title, String image)
    {
        Author=author;
        Title=title;
        Image=image;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return Title;
    }

    public String getImage() {
        return Image;
    }

    public String getImageBase() {
        return imageBase;
    }
}
