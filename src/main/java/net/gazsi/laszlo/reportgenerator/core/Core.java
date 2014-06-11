package net.gazsi.laszlo.reportgenerator.core;

import net.gazsi.laszlo.reportgenerator.model.Config;
import net.gazsi.laszlo.reportgenerator.model.Filter;
import net.gazsi.laszlo.reportgenerator.model.FilterType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Core {

    public static void main(String[] args) throws IOException {
        File file = new File("data/2014-05-22.csv");
        Config config = new Config();
        config.setValueSeparator(",");

        Filter testFilter = new Filter();
        testFilter.setIndex(3);
        testFilter.setValue("Salary");
        //testFilter.setExclusion(true);

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(testFilter);

        Parser.parse(file, config, FilterType.OR, filters);
    }

}
