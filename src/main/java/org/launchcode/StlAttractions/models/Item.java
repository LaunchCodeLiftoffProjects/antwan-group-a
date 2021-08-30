package org.launchcode.StlAttractions.models;

public class Item {
    private String item_category;
    private String item_name;
    private String item_link;

    public Item(String item_category, String item_name, String item_link) {
        this.item_category = item_category;
        this.item_name = item_name;
        this.item_link = item_link;
    }


    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_link() {
        return item_link;
    }

    public void setItem_link(String item_link) {
        this.item_link = item_link;
    }
}
