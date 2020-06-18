package com.krealll.day3.parser;

import com.krealll.day3.entity.Ball;
import com.krealll.day3.entity.Basket;
import com.krealll.day3.entity.Color;
import com.krealll.day3.exception.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String COLOR_REG_EX="[A-Z][a-z]*",
            BALL_REG_EX = COLOR_REG_EX+"[ ][0-9]*\\.[0-9]*",
            BASKET_REG_EX = "Basket:\n("+BALL_REG_EX+"\n)*",
            BASKET_SPLIT_PATTERN = "\n";

    public Basket toBasketValue(String basketString) throws ParseException {
        try {
            Ball tempBall;
            double currentWeight=0;
            List<Ball> ballList = new ArrayList<>();
            ArrayList<String> tokenArray= new ArrayList<>();
            Pattern pattern = Pattern.compile(BASKET_REG_EX);
            Matcher matcher= pattern.matcher(basketString);
            if(matcher.matches()){
                Collections.addAll(tokenArray, basketString.split(BASKET_SPLIT_PATTERN));
                tokenArray.remove(0);
                for (String s : tokenArray) {
                    tempBall = toBallValue(s);
                    currentWeight += tempBall.getWeight();
                    ballList.add(tempBall);
                }
                return new Basket(ballList,currentWeight);
            }
                throw new ParseException("Bad basket string");
        }catch (NumberFormatException e){
            throw new ParseException("Bad number format");
        }
    }

    public Ball toBallValue(String ballString) throws ParseException{
        try{
            double weight;
            Color color;
            ArrayList<String> tokenArray= new ArrayList<>();
            Pattern pattern = Pattern.compile(BALL_REG_EX);
            Matcher matcher= pattern.matcher(ballString);
            if(matcher.matches()){
                Collections.addAll(tokenArray, ballString.split(" "));
                color= toColorValue(tokenArray.get(0));
                weight=Double.parseDouble(tokenArray.get(1));
                return new Ball(color,weight);
            }
                throw new ParseException("Bad ball string");
        } catch (NumberFormatException e){
            throw new ParseException("Bad number format");
        }
    }

    public Color toColorValue(String colorString) throws ParseException {
        Pattern pattern = Pattern.compile(COLOR_REG_EX);
        Matcher matcher= pattern.matcher(colorString);
        Color color;
        if(matcher.matches()){
            switch (colorString){
                case"Red":
                    color=Color.RED;
                    break;
                case"Blue":
                    color= Color.BLUE;
                    break;
                case"Green":
                    color= Color.GREEN;
                    break;
                case"White":
                    color= Color.WHITE;
                    break;
                case"Back":
                    color= Color.BLACK;
                    break;
                case"Grey":
                    color= Color.GREY;
                    break;
                case"Yellow":
                    color= Color.YELLOW;
                    break;
                case"Orange":
                    color= Color.ORANGE;
                    break;
                case"Purple":
                    color= Color.PURPLE;
                    break;
                case"Brown":
                    color= Color.BROWN;
                    break;
                default:
                    throw new ParseException("Not existing color");
            }
            return color;
        }else {
            throw new ParseException("Bad color string");
        }
    }
}
