package org.launchcode.StlAttractions.models;
import org.launchcode.StlAttractions.models.Attraction;

import java.util.ArrayList;

// This is a change made in sandbox.

/**
 * Created by LaunchCode
 */
public class AttractionData {


    /**
     * Returns the results of searching the Jobs data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Job field that should be searched.
     * @param value Value of the field to search for.
     * @param allList The list of jobs to search.
     * @return List of all jobs matching the criteria.
     */
    public static ArrayList<Attraction> findByColumnAndValue(String column, String value, Iterable<Attraction> allList) {

        ArrayList<Attraction> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Attraction>) allList;
        }

        if (column.equals("all")){
            results = findByValue(value, allList);
            return results;
        }
        for (Attraction attraction : allList) {

            String aValue = getFieldValue(attraction, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(attraction);
            }
        }

        return results;
    }

    public static String getFieldValue(Attraction attraction, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = attraction.getName();
        } else if (fieldName.equals("category")) {
            theValue = attraction.getCategory().toString();
        }else if (fieldName.equals("address")){
                theValue = attraction.getAddress().toString();
        } else if (fieldName.equals("link")) {
            theValue = attraction.getLinkForAttraction().toString();
        }else {
            theValue = attraction.getAttractions().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allList The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Attraction> findByValue(String value, Iterable<Attraction> allList) {
        String lower_val = value.toLowerCase();

        ArrayList<Attraction> results = new ArrayList<>();

        for (Attraction attraction : allList) {

            if (attraction.getName().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            }  else if (attraction.getCategory().toString().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            }else if (attraction.getAddress().toString().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            }else if (attraction.getLinkForAttraction().toString().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            } else if (attraction.getAttractions().toString().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            } else if (attraction.toString().toLowerCase().contains(lower_val)) {
                results.add(attraction);
            }

        }

        return results;
    }


}


