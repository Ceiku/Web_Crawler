import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by Daniel on 03/11/2015.
 * This class contains the total amount of words found in a hashmap as keys.
 * And the values are arraylists of strings representing url to pages with hits.
 */
public class WebPageIndexed {
    public String linkName;
    public HashMap<String, ArrayList<Integer>> words;

    public WebPageIndexed(String linkName){
        this.linkName = linkName;
        words = new HashMap<>();
    }
}
