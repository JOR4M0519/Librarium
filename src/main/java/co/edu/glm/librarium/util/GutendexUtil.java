package co.edu.glm.librarium.util;

import co.edu.glm.librarium.model.dto.ListBookDTO;
import co.edu.glm.librarium.services.IBookPortOut;
import org.springframework.stereotype.Component;

@Component
public class GutendexUtil implements IBookPortOut {
    //@Value("${urlBase}")
    private String urlConsume = "https://gutendex.com/books";

    //@Value("${searchParam}")
    private String searchParam = "/?search=";


    @Override
    public ListBookDTO getBooksListByNameGutendex(String name) {
        DTOMapping dtoMapping = new DTOMapping();
        ApiConsume apiConsume = new ApiConsume();
        System.out.println(urlConsume+searchParam+changeBlankSpaceFormat(name));
        var json = apiConsume.getData(urlConsume+searchParam+changeBlankSpaceFormat(name));
        return dtoMapping.geData(json, ListBookDTO.class);
    }

    public String changeBlankSpaceFormat(String name){
        return name.replace(" ", "%20");
    }
}
