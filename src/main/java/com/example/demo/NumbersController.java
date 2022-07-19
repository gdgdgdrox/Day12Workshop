package com.example.demo;

import java.io.File;
import java.util.*;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NumbersController{

    @RequestMapping("/")
    public String showForm(Model model){
        Numbers theNumber = new Numbers();
        model.addAttribute("number", theNumber);
        return "showForm";
    }

    @PostMapping("/resultPage")
    public String resultPage(@Valid @ModelAttribute("number") Numbers myNumber, 
                            BindingResult bindingResult, 
                            Model model){
        if (bindingResult.hasErrors()){
            return ("showForm");
        }
        else {
            File imageFolder = new File ("./src/main/resources/static/images");
            String[] arrayOfImages = imageFolder.list();
            int numberOfImages = arrayOfImages.length;
            int numberFromUser = myNumber.getNumberThatUserEntered();
            Set<String> randomizedList = new HashSet<>();
            Random random = new Random();
            for (int i = 1; i <= numberFromUser; i++){
                int randomIndex = random.nextInt(numberOfImages);
                if (!randomizedList.add(arrayOfImages[randomIndex]))
                    i--;
                }
            model.addAttribute("pictures", randomizedList);
            return "resultPage";
        }
}

}