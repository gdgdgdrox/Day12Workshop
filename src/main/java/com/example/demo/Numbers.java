package com.example.demo;

import javax.validation.constraints.*;

public class Numbers {
    
    @Min(value=1, message="must be equal or greater than 1")  
    @Max(value=31, message="must be equal or less than 31")  
    private int numberThatUserEntered;    

    public int getNumberThatUserEntered() {
        return this.numberThatUserEntered;
    }

    public void setNumberThatUserEntered(int numberThatUserEntered) {
        this.numberThatUserEntered = numberThatUserEntered;
    }


}
