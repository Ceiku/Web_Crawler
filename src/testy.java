import java.util.ArrayList;

/**
 * Created by Daniel on 03/11/2015.
 */
public class testy {
    private int a;
    public testy(int a){
        this.a = a;
        changeA(a);
    }
    public void changeA(int a){
        this.a += a;
    }

    public String toString(){
        return ""+a;
    }

    public static void main(String[] args) {


        ArrayList<String> temp = new ArrayList<>();

        String link = "en.wikipedia.org/wiki/Main_Page";
        String domain = "";
        int i;
        for (i = 0; i <link.length(); i++) {
            if (link.charAt(i) == '/')
                break;
            domain += (link.charAt(i));
        }
        temp.add(domain);
        temp.add(link.substring(i));

        System.out.println(temp.toString());
    }
}
