package ntou.hw2;

public class Sight {
	private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String address;
    private String description;

    public void setSightName(String name){
        this.sightName = name;
    }

    public void setZone(String zone){
        this.zone = zone;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setPhotoURL(String photoURL){
        this.photoURL = photoURL;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getSightName(){
        return sightName;
    }

    public String getZone(){
        return zone;
    }

    public String getCategory(){
        return category;
    }

    public String getPhotoURL(){
        return photoURL;
    }

    public String getAddress(){
        return address;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return "\nSightName: " + getSightName() + "\nZone: " + getZone() + "\nCategory: "
                + getCategory() + "\nPhotoURL: " + getPhotoURL() + "\nDescription: " + getDescription()
                + "\nAddress: " + getAddress();
    }
}
