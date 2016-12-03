import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyEngine implements SearchEngine {

    private static final int DEFAULT_SIZE = 10000;

    //links er ikke med i sluttprodukt lenger; har ikke mye å si for minnet
    private static final String linkPrefix = "https://";

    private int max, bfsIndex, indexSize;
    private boolean isDFS;


    ArrayList<String> sources;
    HashSet<String> parents;
    HashSet<String> validWords;
    public HashMap<String, HashSet<String>> searchMap;


    public static HashSet<String> fromLinedFile(String path){
        HashSet<String> temp = new HashSet<>();
        File f = new File(path);
        Scanner sc;
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()){
                String s = sc.nextLine();
                temp.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
    public void setDFS(boolean b){
        isDFS = b;
    }

    public MyEngine(){ // DONE
        this(DEFAULT_SIZE);
    }

    public MyEngine(int theMax) { // DONE
        sources = new ArrayList<>(200);
        parents = new HashSet<>(200);
        indexSize = 0;
        searchMap = new HashMap<>(300);
        validWords = new HashSet<>(20068);
        isDFS = false;
        bfsIndex = 0;

        //fetchViableWords();
        setMax(theMax);
    }

    public void setMax(int theMax){ // DONE
        max = theMax;
    }

    public boolean setBreadthFirst(){ // TODO
        setDFS(true);
        return true;
    }

    public boolean setDepthFirst(){ // TODO
        setDFS(true);
        return true;
    }
    public ArrayList<String> splitUrl(String link){
        ArrayList<String> temp = new ArrayList<>();
        String domain = "";
        int i;
        for (i = 0; i <link.length(); i++) {
            if (link.charAt(i) == '/')
                break;
            domain += (link.charAt(i));
        }
        temp.add(domain);
        temp.add(link.substring(i));

        return temp;
    }


    public void crawlFrom(String webAdress) { // TODO
        WebPageReader wp;
        validWords = fromLinedFile("words.txt");

        double now = System.nanoTime();
        sources.add(webAdress);

        while (true) {

            if (isDFS) {
                webAdress = sources.get(sources.size() - 1);
                //System.out.println(sources.size());
                sources.remove(sources.size() - 1);
            } else {
                webAdress = sources.get(bfsIndex);
                bfsIndex++;
            }
            wp = new WebPageReader(webAdress);

            for (String word : wp.getWords()) {

                if (searchMap.containsKey(word)) {
                    if (searchMap.get(word).add(wp.toString().substring(8)))
                        indexSize++;
                }
                else if (validWords.contains(word)) {
                    HashSet<String> temp = new HashSet<>();
                    temp.add(wp.toString().substring(8));
                    searchMap.put(word, temp);
                    indexSize++;
                }
                if (size() >= max) {
                    parents = null;
                    sources = null;
                    validWords = null;
                    System.gc();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\n" + (System.nanoTime() - now));
                    return;
                }
            }
            for (String possibleChild : wp.getLinks()) {
                if (parents.add(possibleChild)) {
                    sources.add(possibleChild);
                }
            }
        }
    }
    public String[] searchHits(String target){ // TODO
        String[] t = new String[0];
        try {
            t = searchMap.get(target).toArray(new String[0]);
            for (int i = 0; i < t.length; i++) {
                t[i] = linkPrefix + t[i];
            }
            return t;
        } catch (NullPointerException ne){
            return t;
        }
    }

    public int size(){ // DONE
        return indexSize;
    }
}