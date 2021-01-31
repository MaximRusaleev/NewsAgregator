package ru.sbrf.newsagregator.entity.newyorktimesapi;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "main",
        "kicker",
        "content_kicker",
        "print_headline",
        "name",
        "seo",
        "sub"
})
public class Headline {

    @JsonProperty("main")
    private String main;
    @JsonProperty("kicker")
    private Object kicker;
    @JsonProperty("content_kicker")
    private Object contentKicker;
    @JsonProperty("print_headline")
    private String printHeadline;
    @JsonProperty("name")
    private Object name;
    @JsonProperty("seo")
    private Object seo;
    @JsonProperty("sub")
    private Object sub;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("main")
    public String getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(String main) {
        this.main = main;
    }

    @JsonProperty("kicker")
    public Object getKicker() {
        return kicker;
    }

    @JsonProperty("kicker")
    public void setKicker(Object kicker) {
        this.kicker = kicker;
    }

    @JsonProperty("content_kicker")
    public Object getContentKicker() {
        return contentKicker;
    }

    @JsonProperty("content_kicker")
    public void setContentKicker(Object contentKicker) {
        this.contentKicker = contentKicker;
    }

    @JsonProperty("print_headline")
    public String getPrintHeadline() {
        return printHeadline;
    }

    @JsonProperty("print_headline")
    public void setPrintHeadline(String printHeadline) {
        this.printHeadline = printHeadline;
    }

    @JsonProperty("name")
    public Object getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Object name) {
        this.name = name;
    }

    @JsonProperty("seo")
    public Object getSeo() {
        return seo;
    }

    @JsonProperty("seo")
    public void setSeo(Object seo) {
        this.seo = seo;
    }

    @JsonProperty("sub")
    public Object getSub() {
        return sub;
    }

    @JsonProperty("sub")
    public void setSub(Object sub) {
        this.sub = sub;
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