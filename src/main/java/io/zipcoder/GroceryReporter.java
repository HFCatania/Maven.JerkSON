package io.zipcoder;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.match.Match;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    public List<String> inputNormalizer(){
        try {
            Path path = Paths.get(FileReader.readFile(getOriginalFileText()));
            Stream<String> lines = Files.lines(path);
            lines.map(line -> line.replaceAll("@", ":"));
            lines.map(line -> line.replaceAll("\\^", ":"));
            lines.map(line -> line.replaceAll("\\*", ":"));
            lines.map(line -> line.replaceAll("%", ":"));
            List<String> normalized = lines.collect(Collectors.toList());

            return normalized;

        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
        }

    public List<String> inputSeperator(){
            String normalizedString = inputNormalizer().toString();
            Pattern pattern = Pattern.compile("\\S+\\s*##\\s*\\S+");
            Matcher matcher = pattern.matcher(normalizedString);
            List<String> splitString = new ArrayList<>();
            while(matcher.find()){
                String subStr = matcher.group(1);
                splitString.add(subStr);
            }

        return splitString;

    }



    public HashMap<String, Double> mapMap() {
        Map<String, Double> itemMap = new HashMap<>();
        List<String> listOne = inputSeperator();

        return null;
    }

    public String stringify(){
       return inputSeperator().toString();
    }


    //Seriously, fuck this lab!


    public String getOriginalFileText() {
        return originalFileText;
    }

    @Override
    public String toString() {
        return null;
    }
}
