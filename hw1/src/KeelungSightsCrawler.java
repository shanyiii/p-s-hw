import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class KeelungSightsCrawler {
    private Element points;
    public KeelungSightsCrawler(){
        try{
            Document doc = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();
            points = doc.getElementById("guide-point");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Sight> getItem(String zone){
        ArrayList<Sight> sights = new ArrayList<Sight>();
        Elements zones = points.select("h4"); //區
        Elements ul = points.select("ul");
        int i = 1;
        for(Element ele : zones){
            if(ele.text().equals(zone)){
//                System.out.println("found" + ele.text());
                Elements li = ul.get(i).select("li"); //景點
                for(Element site : li){
                    String url = site.select("a").attr("href"); //景點介紹網址
//                    System.out.println(url + " " + site.select("a").text());
                    Sight sight = new Sight();
                    try{
                        Document view = Jsoup.connect("https://www.travelking.com.tw" + url).get();
                        Element content = view.getElementById("point_area");
                        sight.setPhotoURL(content.select("img").attr("data-src"));
                        sight.setDescription(content.select("meta[itemprop=description]").attr("content"));
                        sight.setAddress(content.select("meta[itemprop=address]").attr("content"));
                        sight.setCategory(content.getElementsByClass("point_type").select("strong").text());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    sight.setZone(ele.text());
                    sight.setSightName(site.select("a").text());
                    sights.add(sight);
                }
            }
            i++;
        }
        return sights;
    }
}