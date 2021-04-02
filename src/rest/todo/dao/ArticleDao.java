package rest.todo.DAO;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import rest.todo.model.Article;
import rest.todo.model.Categorie;
import rest.todo.DAO.CategorieDAO;

public enum ArticleDAO {
    instance;

    private HashMap<Integer, Article> contentProvider = new HashMap<>();

    private ArticleDAO() {
        Article article = new Article(1, "PC portable", "HP", 900.5, "https://d1eh9yux7w8iql.cloudfront.net/product_images/302929_723f26b0-44c9-4041-8e44-ff6a1cb62ace.jpg");
        article.addCategorie(CategorieDAO.instance.getModel().get(1));
        Article article2 = new Article(2, "PC bureau", "marque2", 1026.5, "https://d1eh9yux7w8iql.cloudfront.net/product_images/1460370107.83.jpg");
        article2.addCategorie(CategorieDAO.instance.getModel().get(2));
        Article article3 = new Article(3, "Accessoire d'ordinateur", "marque3", 26.5, "https://images-na.ssl-images-amazon.com/images/I/61dZNcZAGnL._AC_SX679_.jpg");
        Article article4 = new Article(4, "Iphone 12 ", "Apple", 1026.5, "https://www.itech-repair.fr/2326-thickbox_default/iphone-7-256go-rose.jpg");
        Article article41 = new Article(4, "Iphone X", "Apple", 650.5, "https://www.10wallpaper.com/wallpaper/2560x1600/1711/Apple_2017_iPhone_X_iPhone_10_HD_Wallpaper_02_2560x1600.jpg");
        Article article42 = new Article(4, "Xiaomi Mi 9", "Apple", 420.5, "https://images.frandroid.com/wp-content/uploads/2019/05/mi-9.jpg");
        Article article43 = new Article(4, "Xiaomi Mi 10", "Apple", 400.5, "https://www.notebookcheck.biz/fileadmin/Notebooks/Xiaomi/Mi_10/Xiaomi_Mi_10_4zu3.jpg");
        Article article44 = new Article(4, "Samsung galaxy S9", "Apple", 850.5, "https://www.mobile24.fr/images2/Samsung-Galaxy-S9-64GB-Coral-Blue-27022018-01-p.jpg");
        Article article45 = new Article(4, "Samsung galaxy s20", "Apple", 625.5, "https://www.media-rdc.com/medias/d54bc809aca63bb6a3cf7acfdc95c569/samsung-galaxy-s20-rose-0.png");
        Article article46 = new Article(4, "One Plus 7 pro", "Apple", 850.5, "https://images.frandroid.com/wp-content/uploads/2019/04/oneplus-7-pro-2019-frandroid.png");
        Article article47 = new Article(4, "Oppo f11 ", "Apple", 600.5, "https://media.ldlc.com/r1600/mkp/e5543fab0a684a9fb076fe34af3367b7.jpeg");
        Article article5 = new Article(5, "Telephone fix", "marque3", 32.5, "https://static.fnac-static.com/multimedia/Images/87/87/8F/7C/8163207-1505-1505-1/tsp20200810190707/Gigaset-A170-Solo-Telephone-fixe-sans-fil-DECT-GAP-Noir.jpg");
        Article article6 = new Article(6, "chargeur Iphone", "marque2", 35.5, "https://static.fnac-static.com/multimedia/Images/FR/MC/d6/31/6c/23867862/1540-1/tsp20170214170553/Chargeur-Secteur-Cable-Usb-Iphone-6.jpg#8cbd8d60-5bbd-42dc-bec1-54f1adb314fd");
        Article article7 = new Article(7, "Disque dur 500 GO", "samsung", 80.5, "https://m.media-amazon.com/images/I/61+D1lyvOPL._AC_SX425_.jpg");
        Article article8 = new Article(8, "Clé usb", "hp", 22.5, "https://static.fnac-static.com/multimedia/Images/FR/MDM/ee/6f/2f/3108846/1540-1/tsp20200718130428/Cle-USB-2-0-Sandisk-Cruzer-Blade-128-Go.jpg");
        Article article9 = new Article(9, "Accessoires stockage", "marque2", 28.5, "NoURL");
        article3.addCategorie(CategorieDAO.instance.getModel().get(3));
        
        article4.addCategorie(CategorieDAO.instance.getModel().get(4));
        article41.addCategorie(CategorieDAO.instance.getModel().get(4));
        article42.addCategorie(CategorieDAO.instance.getModel().get(4));
        article43.addCategorie(CategorieDAO.instance.getModel().get(4));
        article44.addCategorie(CategorieDAO.instance.getModel().get(4));
        article45.addCategorie(CategorieDAO.instance.getModel().get(4));
        article46.addCategorie(CategorieDAO.instance.getModel().get(4));
        article47.addCategorie(CategorieDAO.instance.getModel().get(4));


        
        article5.addCategorie(CategorieDAO.instance.getModel().get(5));
        article6.addCategorie(CategorieDAO.instance.getModel().get(6));
        article7.addCategorie(CategorieDAO.instance.getModel().get(7));
        article8.addCategorie(CategorieDAO.instance.getModel().get(8));
        article9.addCategorie(CategorieDAO.instance.getModel().get(9));




        contentProvider.put(1, article);
        contentProvider.put(2, article2);
        contentProvider.put(3, article3);
        contentProvider.put(4, article4);
        contentProvider.put(41, article41);
        contentProvider.put(42, article42);
        contentProvider.put(43, article43);
        contentProvider.put(44, article44);
        contentProvider.put(45, article45);
        contentProvider.put(46, article46);
        contentProvider.put(47, article47);

        contentProvider.put(5, article5);
        contentProvider.put(6, article6);
        contentProvider.put(7, article7);
        contentProvider.put(8, article8);
        contentProvider.put(9, article9);



    }

    public HashMap<Integer, Article> getModel(){
        return contentProvider;
    }

    public Map<Integer, Article> getArticlesByCategorie(Categorie categorie){
        return contentProvider.entrySet().stream().filter(x -> x.getValue().getCategories().contains(categorie)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}