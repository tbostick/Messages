package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // First let's create a author
        Author author = new Author();
        author.setTitle("Donald Trump");
        author.setContent("Lastest Rant");

        //Now let's create a message
        Messages messages = new Messages();
        messages.setTitle("Fake News");
        messages.setPostedBy("Donald Trump");
        messages.setPostedDate(2019);


        //Add the message to an empty list
        Set<Messages> message = new HashSet<Messages>();
        message.add(messages);

        messages = new Messages();
        messages.setTitle("Green New Deal");
        messages.setPostedDate(2019);
        messages.setPostedBy("Donald Trump");
        message.add(messages);

        //Add the list of messages to the authors message list
        author.setContent("message");

        //Grab all authors from the database and send them to
        //the template
        model.addAttribute("authors", authorRepository.findAll());
                return "index";
    }
}

