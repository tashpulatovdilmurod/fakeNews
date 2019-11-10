package JsonExtracter;

import Model.Data;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ParseJson
{
    @SuppressWarnings("unchecked")
    public List<Data> parse() 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("C:\\Users\\Dilmurod Tashpulatov\\Desktop\\JavaFxWebViewExample\\sample.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray dataList = (JSONArray) obj;
            //Iterate over employee array
            List<Data> list = ParseJson.parseEmployeeObject(dataList);
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    private static List<Data> parseEmployeeObject(JSONArray dataList) 
    {
        List<Data> dataListReturn = new ArrayList<>();
        for(int i = 0; i < dataList.size(); i++){
            JSONObject data = (JSONObject) dataList.get(i);
            
            String url = (String) data.get("url");
            String source = (String) data.get("source");
            String claim = (String) data.get("claim");
            String claim_url = (String) data.get("claim_url");
            String label = (String) data.get("label");
            String author = (String) data.get("author");
            String date = (String) data.get("date");
            
            Data newData = new Data(url,source,claim,claim_url,label,author,date);
            dataListReturn.add(newData);
        }
        return dataListReturn;
        
    }
}
