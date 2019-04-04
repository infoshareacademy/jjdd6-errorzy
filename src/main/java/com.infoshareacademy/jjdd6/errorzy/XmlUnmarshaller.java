package com.infoshareacademy.jjdd6.errorzy;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
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

        System.out.println(Arrays.listOfCountries());

//        List<String> mar = markerslist.getCountryList()
//                .stream()
//                .map()
//                .;

//        System.out.println(markerslist.getCountryList()
//                .stream()
//                .map(c->c.getCountry_name())
//                .fo);
//
//        for (Country c : markerslist.getCountryList()) {
//            for (City city : c.getCityList()) {
//                city.getName();
//                System.out.println(city.getName());
//            }
//        }


//        List <Country> uniqueListOfCountry = Arrays.asList(){
//
//        }

//        System.out.println(markerslist.getCountryList()
//                .stream()
//                .map(c -> {
//                    double lat = c.getLat();
//                    double lng = c.getLng();
//                    return lat + lng;
//                }
//                .collect(Collectors.toList())));


    }

    public static List<String> listOfCountries(List<Country> countries) {
        return  countries.stream()
                .distinct()
                .map(Country::getCountry_name)
                .collect(Collectors.toList());
    }
}
