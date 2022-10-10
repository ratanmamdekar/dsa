package com.dsa.mics;

import java.util.*;

public class TimeBasedKeyValueStore {
    class TimeMap {
        HashMap<String, TreeMap<Integer, String>> keyTimeMap;

        public TimeMap() {
            keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
        }

        public void set(String key, String value, int timestamp) {
            if (!keyTimeMap.containsKey(key)) {
                keyTimeMap.put(key, new TreeMap<Integer, String>());
            }

            // Store '(timestamp, value)' pair in 'key' bucket.
            keyTimeMap.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            // If the 'key' does not exist in map we will return empty string.
            if (!keyTimeMap.containsKey(key)) {
                return "";
            }

            SortedMap<Integer, String> floorKey = keyTimeMap.get(key).headMap(timestamp);
            // Return searched time's value, if exists.
            if (!floorKey.isEmpty()) {
                return floorKey.get(floorKey.lastKey());
            }

            return "";
        }
    }

    /*
    Input ["TimeMap", "set", "get", "get", "set", "get", "get"]
          [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
    Output [null, null, "bar", "bar", null, "bar2", "bar2"]
    */
    public static void main(String[] args) {

    }

}
