package com.ghost;

public class Player {

    private String name;
    private VARIANT variant;
    private String result;


    Player(){
        this.name = "Bot";
        //Данный цикл добавил для большой "рандомности", с ним чаще стали выпадать разные варианты)))
        for (int i = 0; i < 17; i++)
            Math.random();

        double numb = Math.random();
        //System.out.println(numb);
        if (numb < 0.4563774d)
            variant = Player.VARIANT.ROCK;
        else if (numb > 0.6754365d)
            variant = Player.VARIANT.SCISSORS;
        else
            variant = Player.VARIANT.PAPER;
    }
    Player(VARIANT variant, String name){
        this.name = name;
        this.variant = variant;
    }

    public enum VARIANT {
        ROCK,
        PAPER,
        SCISSORS
    }

    public String getName() {
        return name;
    }

    public VARIANT getVariant() {
        return variant;
    }

    public String whoWins (Player user1, Player user2){

        switch (user1.getVariant()){

            case ROCK:
                if (user2.getVariant() == VARIANT.ROCK)
                    this.result = "Ничья!!!";
                else if (user2.getVariant() == VARIANT.PAPER)
                    this.result = "Поьедил игрок с именем: " + user2.getName();
                else
                    this.result = "Поьедил игрок с именем: " + user1.getName();
                break;
            case PAPER:
                if (user2.getVariant() == VARIANT.PAPER)
                    this.result = "Ничья!!!";
                else if (user2.getVariant() == VARIANT.SCISSORS)
                    this.result = "Поьедил игрок с именем: " + user2.getName();
                else
                    this.result = "Поьедил игрок с именем: " + user1.getName();
                break;
            case SCISSORS:
                if (user2.getVariant() == VARIANT.SCISSORS)
                    this.result = "Ничья!!!";
                else if (user2.getVariant() == VARIANT.ROCK)
                    this.result = "Поьедил игрок с именем: " + user2.getName();
                else
                    this.result = "Поьедил игрок с именем: " + user1.getName();
                break;
        }

        return this.result;
    }

}
