package edu.el.content.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @Lob
    private String summary;
    @Lob
    private String description;
    private String syllable;
    private String thumbnail;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "contributors")
    private List<Long> contributors = new ArrayList<>();

    public Course() {
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSyllable() {
        return syllable;
    }

    public void setSyllable(String syllable) {
        this.syllable = syllable;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addContributor(Long contributorId) {
        contributors.add(contributorId);
    }

    public void removeContributor(Long contributorId) {
        contributors.remove(contributorId);
    }

    public void addContent(Content content) {
        contents.add(content);
    }

    public void removeContent(Content content) {
        contents.remove(content);
    }

    public List<Content> getContents() {
        return contents;
    }
}
