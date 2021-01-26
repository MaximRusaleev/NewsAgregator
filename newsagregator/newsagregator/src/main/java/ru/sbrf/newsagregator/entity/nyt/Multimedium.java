package ru.sbrf.newsagregator.entity.nyt;

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
        "rank",
        "subtype",
        "caption",
        "credit",
        "type",
        "url",
        "height",
        "width",
        "legacy",
        "subType",
        "crop_name"
})
public class Multimedium {

    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("subtype")
    private String subtype;
    @JsonProperty("caption")
    private Object caption;
    @JsonProperty("credit")
    private Object credit;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("legacy")
    private Object legacy;
    @JsonProperty("subType")
    private String subType;
    @JsonProperty("crop_name")
    private String cropName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("subtype")
    public String getSubtype() {
        return subtype;
    }

    @JsonProperty("subtype")
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @JsonProperty("caption")
    public Object getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(Object caption) {
        this.caption = caption;
    }

    @JsonProperty("credit")
    public Object getCredit() {
        return credit;
    }

    @JsonProperty("credit")
    public void setCredit(Object credit) {
        this.credit = credit;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("legacy")
    public Object getLegacy() {
        return legacy;
    }

    @JsonProperty("legacy")
    public void setLegacy(Object legacy) {
        this.legacy = legacy;
    }

    @JsonProperty("subType")
    public String getSubType() {
        return subType;
    }

    @JsonProperty("subType")
    public void setSubType(String subType) {
        this.subType = subType;
    }

    @JsonProperty("crop_name")
    public String getCropName() {
        return cropName;
    }

    @JsonProperty("crop_name")
    public void setCropName(String cropName) {
        this.cropName = cropName;
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