package com.example.game;
import java.util.ArrayList;

// 创建类
public class Player {

    //创建字段
    private int money = 500;
    private ArrayList<Rinkko> pets;

    // 构造方法，无参数
    public Player(){
        this.money = 500;
        this.pets = new ArrayList<>(); // 这是一个空的喵喵列表
    }
}

