package co.edu.glm.librarium.util;

import co.edu.glm.librarium.model.dto.BookDTO;
import co.edu.glm.librarium.model.dto.ListBookDTO;
import co.edu.glm.librarium.services.IBookPortOut;
import org.springframework.stereotype.Component;

@Component
public class GutendexUtil implements IBookPortOut {
    //@Value("${urlBase}")
    private String urlConsume = "https://gutendex.com/books";

    //@Value("${searchParam}")
    private String searchParamName = "/?search=";

    private String searhParamID = "/?ids=";


    @Override
    public ListBookDTO getBooksListByNameGutendex(String name) {
        DTOMapping dtoMapping = new DTOMapping();
        ApiConsume apiConsume = new ApiConsume();

        var json = apiConsume.getData(urlConsume+searchParamName+changeBlankSpaceFormat(name));
        return dtoMapping.geData(json, ListBookDTO.class);
    }

    @Override
    public BookDTO getBookById(int id) {
        DTOMapping dtoMapping = new DTOMapping();
        ApiConsume apiConsume = new ApiConsume();

        var json = apiConsume.getData(urlConsume+searhParamID+id);
        System.out.println(urlConsume+searhParamID+id);
        return dtoMapping.geData(json, ListBookDTO.class).bookDTOList().get(0);
    }

    public String changeBlankSpaceFormat(String name){
        return name.replace(" ", "%20");
    }
}
