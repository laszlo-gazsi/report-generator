package net.gazsi.laszlo.reportgenerator.core;

import net.gazsi.laszlo.reportgenerator.model.Config;
import net.gazsi.laszlo.reportgenerator.model.Filter;
import net.gazsi.laszlo.reportgenerator.model.FilterType;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser {

    private static Set<String> categories = new HashSet<String>();

    public static void parse(File file, Config config, FilterType filterType, List<Filter> filters) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line;
        while ((line = br.readLine()) != null){
            String[] fields = line.split(",");
            if (doesMatch(fields, filters)) {
                categories.add(line);
            }
        }

        printSet(categories);
    }

    private static boolean doesMatch(String[] record, List<Filter> filters){
        boolean match = true;
        for (Filter filter : filters){
            if (!filter.filter(record)){
                match = false;
                break;
            }
        }

        return match;
    }

    private static void printSet(Set<String> set){
        for (String item : set){
            System.out.println(item);
        }
    }
}
