import edu.princeton.cs.algs4.StdIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Daniel on 03/11/2015.
 */

public class DictionaryOfDoesAndDonts {
    private File fDoes, fDonts;
    private HashSet<String> does, donts;
    private Scanner sc;

    public DictionaryOfDoesAndDonts(String doesPath, String dontPath){
        fDoes = new File(doesPath);
        try {
            sc = new Scanner(fDoes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(sc.hasNextLine()){

        }
    }
}
