package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        Pattern pattern = Pattern.compile("\\S+\\s*##\\s*\\S+");
        Matcher matcher = pattern.matcher(valueToParse);
        List<Item> splitString = new ArrayList<>();
        while(matcher.find()){
            Item item = matcher.group(1);
            splitString.add(item);
        }

        return splitString;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        return null;
    }
}
