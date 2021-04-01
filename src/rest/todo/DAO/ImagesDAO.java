package rest.todo.DAO;

import java.util.HashMap;

import rest.todo.model.Article;


public enum ImagesDAO {
    instance;

    private HashMap<Integer, String> contentProvider = new HashMap<>();
    private ImagesDAO() {
        contentProvider.put(1, "https://d1eh9yux7w8iql.cloudfront.net/product_images/326956_f8345bd8-8dc5-4135-be98-8ba38f9accc4.jpg");

    }

    public HashMap<Integer, String> getModel(){
        return contentProvider;
    }
}
