package org.launchcode.StlAttractions.models;

import org.launchcode.StlAttractions.models.Attraction;

import java.util.ArrayList;
import java.util.Comparator;

// This is a change made in sandbox.

/**
 * Created by LaunchCode
 */
public class AttractionData {


    /**
     * Returns the results of searching the Attraction data by field and search term.
     * <p>
     * For example, searching for attraction "Saint Louis" will include results
     * with "Saint Louis, Inc".
     *
     * @param column  Attraction field that should be searched.
     * @param value   Value of the field to search for.
     * @param allAttractions The list of attractions to search.
     * @return List of all attractions matching the criteria.
     */
    public static ArrayList<Attraction> findByColumnAndValue(String column, String value, Iterable<Attraction> allAttractions) {

        ArrayList<Attraction> results = new ArrayList<>();

        if (value.equalsIgnoreCase("all")) {
            return (ArrayList<Attraction>) allAttractions;
        }

        if (column.equals("all")) {
            results = findByValue(value, allAttractions);
            return results;
        }
        for (Attraction attraction : allAttractions) {

            String aValue = getFieldValue(attraction, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(attraction);
            }
        }

        return results;
    }

    public static String getFieldValue(Attraction attraction, String fieldName) {
        String theValue;
        if (fieldName.equals("name")) {
            theValue = attraction.getName();
        }else if (fieldName.equals("category")){
            theValue = attraction.getCategory().toString();
        } else if (fieldName.equals("link")) {
            theValue = attraction.getLinkForAttraction().toString();
        } else {
           theValue = attraction.getAddress().toString();
       }
        return theValue;
}

    /**
     * Search all Attraction fields for the given term.
     *
     * @param value The search term to look for.
     * @param allAttractions The list of attractions to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Attraction> findByValue(String value, Iterable<Attraction> allAttractions) {
        String lower_val = value.toLowerCase();

        ArrayList<Attraction> results = new ArrayList<>();


        for (Attraction attraction : allAttractions) {


            if (attraction.getName().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            }  else if (attraction.getAddress().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            } else if (attraction.getLinkForAttraction().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            } else if (attraction.getCategory().getName().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            }

        }
        return results;
    }


}


