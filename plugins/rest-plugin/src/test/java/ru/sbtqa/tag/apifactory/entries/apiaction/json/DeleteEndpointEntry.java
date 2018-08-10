package ru.sbtqa.tag.apifactory.entries.apiaction.json;

import static org.hamcrest.Matchers.equalTo;
import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.HTTP;
import ru.sbtqa.tag.api.annotation.Endpoint;
import ru.sbtqa.tag.api.annotation.Query;
import ru.sbtqa.tag.api.annotation.Validation;
import ru.sbtqa.tag.apifactory.utils.Default;

@Endpoint(method = HTTP.DELETE, path = "client/delete", title = "delete test")
public class DeleteEndpointEntry extends EndpointEntry {

    @Query(name = Default.PARAMETER_NAME1)
    private String queryParameter = Default.PARAMETER_VALUE1;

    @Validation(title = "result")
    public void validate() {
        getResponse().body("result", equalTo(queryParameter));
    }
}
