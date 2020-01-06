package com.sathish.practice.searchbykey.searchkey;

import com.sathish.practice.searchbykey.ModalSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sathish.practice.searchbykey.configuration.ApplicationConfig.APP_CONTEXT;
import static com.sathish.practice.searchbykey.configuration.ApplicationConfig.GET_LIST_FILES;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = APP_CONTEXT, produces = APPLICATION_JSON_VALUE)
public class ControllerSearchKey {

    @Autowired
    ServiceSearchKey serviceSearchKey;

    @PostMapping(value = GET_LIST_FILES, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<String> getListOfFilesBySearchKey(@RequestBody ModalSearchRequest modalSearchRequest) {
        return serviceSearchKey.getListOfFilesBySearchKey(modalSearchRequest.getDirectoryPath(), modalSearchRequest.getSearchKey());
    }
}
