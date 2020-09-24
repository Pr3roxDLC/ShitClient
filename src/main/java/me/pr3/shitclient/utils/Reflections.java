package me.pr3.shitclient.utils;

import org.apache.commons.lang3.ClassUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Reflections {

    public static HashMap<String, String[]> dumpFields(Object input) {

        HashMap<String, String[]> fieldPairs = new HashMap<>();

        new ArrayList<>(Arrays.asList(input.getClass().getDeclaredFields())).forEach(field -> {

            Object value;
            field.setAccessible(true);

            try {
                value = field.get(input);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            }

            // TODO: call dumpFields(Object o) recursive?
            if (ClassUtils.isPrimitiveOrWrapper(field.getType())) {
                fieldPairs.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof Collection) { // TODO: dump entry values
                fieldPairs.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof Enum) { // TODO: dump enum values
                fieldPairs.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof String) {
                fieldPairs.put(field.getName(), new String[]{field.getType().getTypeName(), (String) value});
            } else if (value == null) {
                fieldPairs.put(field.getName(), new String[]{field.getType().getTypeName(), "null"});
            } else {
                fieldPairs.put(field.getName(), new String[]{field.getType().getTypeName(), "not implemented"});
            }

        });

        return fieldPairs;

    }

}
