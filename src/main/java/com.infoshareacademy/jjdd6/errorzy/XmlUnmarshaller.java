package com.infoshareacademy.jjdd6.errorzy;


import com.infoshareacademy.jjdd6.errorzy.bikeFinder.FindCountry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class XmlUnmarshaller {
    public static void main(String[] args) throws JAXBException {

        System.out.println("Let's ride!");
        System.out.println("                                          $\"   *.      \n" +
                "              d$$$$$$$P\"                  $    J\n" +
                "                  ^$.                     4r  \"\n" +
                "                  d\"b                    .db\n" +
                "                 P   $                  e\" $\n" +
                "        ..ec.. .\"     *.              zP   $.zec..\n" +
                "    .^        3*b.     *.           .P\" .@\"4F      \"4\n" +
                "  .\" *       d\"  ^b.    *c        .$\"  d\" * $      *  %\n" +
                " /     *    P      $.    \"c      d\"   @    * r    *    3\n" +
                "4        .eE........$r===e$$$$eeP    J       *.. *      b\n" +
                "$       $$$$$       $   4$$$$$$$     F       d$$$.      4\n" +
                "$ * * * $$$$$ * * * $   4$$$$$$$     L * * * *$$$\"* * * 4\n" +
                "4         \"      \"\"3P ===$$$$$$\"     3         \"        P\n" +
                " *      *   *      $       \"\"\"        b      *   *     J\n" +
                "  \".  *       *  .P                    %. *        *  @\n" +
                "    %.         z*\"                      ^%.        .r\"\n" +
                "       \"*==*\"\"                             ^\"*==*\"\"   ");
        System.out.println("  ");

        File file = new File("nextbike-official.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Markers.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Markers markerslist = (Markers) jaxbUnmarshaller.unmarshal(file);
        System.out.println(markerslist.getCountryList());

        List<Markers> List2 = Arrays.asList(markerslist);
        getCounries(List2).forEach(System.out::println);


    }
    public static List<String> getCounries(List<Markers> List2){
        return List2.stream()
                .map(Markers::getCountry_name)
                .collect(Collectors.toList());
    };

//    private List<City> getCities(List<Country> countiesData) {
//        List<City> allCities = new LinkedList<>();
//        for (Country c : countiesData) {
//            allCities.addAll(c.getCityList());
//        }
//        return allCities;
//    }
}