package ru.sbrf.newsagregator.entity.newyorktimesapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "original",
        "person",
        "organization"
})
public class Byline {

    @JsonProperty("original")
    private String original;
    @JsonProperty("person")
    private List<Person> person = null;
    @JsonProperty("organization")
    private Object organization;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("original")
    public String getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(String original) {
        this.original = original;
    }

    @JsonProperty("person")
    public List<Person> getPerson() {
        return person;
    }

    @JsonProperty("person")
    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @JsonProperty("organization")
    public Object getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(Object organization) {
        this.organization = organization;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}