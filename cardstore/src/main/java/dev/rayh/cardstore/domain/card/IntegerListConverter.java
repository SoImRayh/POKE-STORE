package dev.rayh.cardstore.domain.card;

import jakarta.persistence.AttributeConverter;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

public class IntegerListConverter implements AttributeConverter<List<Integer>, String> {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        if (attribute == null)
            return null;

        String s = mapper.writeValueAsString(attribute);
        return s;
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;
        List<Integer> list = mapper.readValue(dbData, new TypeReference<List<Integer>>(){});
        return list;
    }
}
