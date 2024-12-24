package co.edu.glm.librarium.util;

import co.edu.glm.librarium.util.IMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DTOMapping implements IMapping {

    private ObjectMapper serieMapper = new ObjectMapper();


    @Override
    public <T> T geData(String json, Class<T> tClass) {
        try {
            return serieMapper.readValue(json,tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
