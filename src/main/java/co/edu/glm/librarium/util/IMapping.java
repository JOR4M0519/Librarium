package co.edu.glm.librarium.util;

public interface IMapping {
    <T> T geData(String json, Class<T> tClass);


}
