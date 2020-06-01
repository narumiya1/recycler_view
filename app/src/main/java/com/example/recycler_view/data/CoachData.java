package com.example.recycler_view.data;

import com.example.recycler_view.model.Coach;

import java.util.ArrayList;

public class CoachData {

    public static String[][] data = new String[][]{

            { "Juergen Klop", "Gelsenchinkern, Germany" , "https://vignette.wikia.nocookie.net/liverpoolfc/images/8/86/JKlopp2019.jpeg/revision/latest?cb=20190807042613"},

            {" Rafael Benitez", "Madrid, Spain ", "https://vignette.wikia.nocookie.net/liverpoolfc/images/7/7f/RBenitez.jpg/revision/latest?cb=20131122010547"},

            {" Kenny Dalglish", "Glasgow, Scotland", "https://vignette.wikia.nocookie.net/liverpoolfc/images/0/01/Kennygalglish111.jpg/revision/latest?cb=20110602022431"},

            {" Louis Van Gaal", "Amsterdam, Netherland", "https://vignette.wikia.nocookie.net/the-football-database/images/6/67/Netherlands_L._van_Gaal_003.png/revision/latest?cb=20140919113617"},

            {" Didier Deschamps ", "Bordeaux, France", "https://vignette.wikia.nocookie.net/the-football-database/images/f/f0/France_D._Deschamps_001.png/revision/latest?cb=20140611161157"},

            {" Joachim Loew", "Schönau, Germany", "https://vignette.wikia.nocookie.net/the-football-database/images/1/1c/Germany_J._L%C3%B6w_002.png/revision/latest?cb=20140708152353"}

    };

    public static ArrayList<Coach> getListData(){
        ArrayList<Coach> list = new ArrayList<>();
        for ( String[] aData : data ){

            Coach coach = new Coach();
            coach.setName(aData[0]);
            coach.setFrom(aData[1]);
            coach.setPhoto(aData[2]);

            list.add(coach);

        }

        return list ;
    }
}
