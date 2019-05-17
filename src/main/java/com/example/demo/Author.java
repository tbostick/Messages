package com.example.demo;

import org.springframework.data.repository.cdi.Eager;
import sun.plugin2.message.Message;

import javax.persistence.*;
import java.util.Set;

@Eager
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    public Set<Message> messages;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
