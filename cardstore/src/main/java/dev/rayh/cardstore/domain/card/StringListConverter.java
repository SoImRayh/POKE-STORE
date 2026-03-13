package dev.rayh.cardstore.domain.card;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {

        if (attribute == null)
            return null;
        String string = "";
        for (String s : attribute){
            string = string.concat( "," + s);
        }

        return string;
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;
        var list = Arrays.stream(dbData.split(",")).toList();
        list = list.stream().map(s -> s.replace(",", "")).toList();
        return list;
    }
}
