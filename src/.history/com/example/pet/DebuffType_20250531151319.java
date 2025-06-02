package com.example.pet;

public enum DebuffType {
    NONE("无"),
    HUNGRY("饿了"),
    THIRSTY("渴了"),
    UNHAPPY("不开心"),
    SICK("生病");

    private final String description;

    DebuffType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 7f5ab5b2aa0d42a6b0d6236287412845a23bfb5a
