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
        "abstract",
        "web_url",
        "snippet",
        "lead_paragraph",
        "print_section",
        "print_page",
        "source",
        "multimedia",
        "headline",
        "keywords",
        "pub_date",
        "document_type",
        "news_desk",
        "section_name",
        "byline",
        "type_of_material",
        "_id",
        "word_count",
        "uri"
})
public class Doc {

    @JsonProperty("abstract")
    private String _abstract;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("snippet")
    private String snippet;
    @JsonProperty("lead_paragraph")
    private String leadParagraph;
    @JsonProperty("print_section")
    private String printSection;
    @JsonProperty("print_page")
    private String printPage;
    @JsonProperty("source")
    private String source;
    @JsonProperty("multimedia")
    private List<Multimedium> multimedia = null;
    @JsonProperty("headline")
    private Headline headline;
    @JsonProperty("keywords")
    private List<Keyword> keywords = null;
    @JsonProperty("pub_date")
    private String pubDate;
    @JsonProperty("document_type")
    private String documentType;
    @JsonProperty("news_desk")
    private String newsDesk;
    @JsonProperty("section_name")
    private String sectionName;
    @JsonProperty("byline")
    private Byline byline;
    @JsonProperty("type_of_material")
    private String typeOfMaterial;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("word_count")
    private Integer wordCount;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("abstract")
    public String getAbstract() {
        return _abstract;
    }

    @JsonProperty("abstract")
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("web_url")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @JsonProperty("snippet")
    public String getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @JsonProperty("lead_paragraph")
    public String getLeadParagraph() {
        return leadParagraph;
    }

    @JsonProperty("lead_paragraph")
    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    @JsonProperty("print_section")
    public String getPrintSection() {
        return printSection;
    }

    @JsonProperty("print_section")
    public void setPrintSection(String printSection) {
        this.printSection = printSection;
    }

    @JsonProperty("print_page")
    public String getPrintPage() {
        return printPage;
    }

    @JsonProperty("print_page")
    public void setPrintPage(String printPage) {
        this.printPage = printPage;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("multimedia")
    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    @JsonProperty("multimedia")
    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    @JsonProperty("headline")
    public Headline getHeadline() {
        return headline;
    }

    @JsonProperty("headline")
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    @JsonProperty("keywords")
    public List<Keyword> getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("pub_date")
    public String getPubDate() {
        return pubDate;
    }

    @JsonProperty("pub_date")
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @JsonProperty("document_type")
    public String getDocumentType() {
        return documentType;
    }

    @JsonProperty("document_type")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @JsonProperty("news_desk")
    public String getNewsDesk() {
        return newsDesk;
    }

    @JsonProperty("news_desk")
    public void setNewsDesk(String newsDesk) {
        this.newsDesk = newsDesk;
    }

    @JsonProperty("section_name")
    public String getSectionName() {
        return sectionName;
    }

    @JsonProperty("section_name")
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @JsonProperty("byline")
    public Byline getByline() {
        return byline;
    }

    @JsonProperty("byline")
    public void setByline(Byline byline) {
        this.byline = byline;
    }

    @JsonProperty("type_of_material")
    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    @JsonProperty("type_of_material")
    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("word_count")
    public Integer getWordCount() {
        return wordCount;
    }

    @JsonProperty("word_count")
    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
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