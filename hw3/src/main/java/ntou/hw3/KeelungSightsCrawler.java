package ntou.hw3;

import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class KeelungSightsCrawler{

    Element points;
    ArrayList<Sight> sights = new ArrayList<Sight>();
    public KeelungSightsCrawler(){

    }

    public ArrayList<Sight> getStarted(){
        try{
            Document doc = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();
            points = doc.getElementById("guide-point");
            Elements views = points.select("li"); //景點
            for(Element site : views){
                String url = site.select("a").attr("href"); //景點介紹網址
//                    System.out.println(url + " " + site.select("a").text());
                Sight sight = new Sight();
                try{
                    Document view = Jsoup.connect("https://www.travelking.com.tw" + url).get();
                    Element content = view.getElementById("content");
                    sight.setZone(content.getElementsByClass("bc_last").text());
                    sight.setPhotoURL(content.select("img").attr("data-src"));
                    sight.setDescription(content.select("meta[itemprop=description]").attr("content"));
                    sight.setAddress(content.select("meta[itemprop=address]").attr("content"));
                    sight.setCategory(content.getElementsByClass("point_type").select("strong").text());
                }
                catch (IOException e){
                    e.printStackTrace();
                }

                sight.setSightName(site.select("a").text());
                sights.add(sight);
                //System.out.println(sight);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return sights;
    }
}