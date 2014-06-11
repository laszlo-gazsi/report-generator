package net.gazsi.laszlo.reportgenerator.model;

public class Filter {

    private int index;

    private String value;

    private boolean exclusion;

    // private MatchType - exact/partial/year/month/...

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isExclusion() {
        return exclusion;
    }

    public void setExclusion(boolean exclusion) {
        this.exclusion = exclusion;
    }

    public boolean filter(String[] record){
        boolean match = record[index].equals(value);
        return isExclusion() ? !match : match;
    }
}
