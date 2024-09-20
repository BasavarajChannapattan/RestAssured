package tests.Existing_Json;

import groovy.json.JsonToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ExistingJsonRequest {

    public void FileExistingSystem() throws FileNotFoundException {
        File f = new File("D:\\Rest\\body.json");
        FileReader fr=new FileReader(f);
//        JSONTokener tokener = new JSONTokener(fr);
//        JSONObject js = new JSONObject(tokener);

    }
}
