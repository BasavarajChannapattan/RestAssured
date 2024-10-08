package resources;

import pojo.addPlace;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public addPlace addPlacePayLoad(String name, String language, String address)
    {
        addPlace p =new addPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName(name);
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        location l =new location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public String deletePlacePayLoad(String placeId)
    {
        return  "{\r\n\"place_id\":\""+placeId+"\"\r\n}\r\n}";
    }
}
