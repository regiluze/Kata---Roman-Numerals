package org.kataingles

import java.security.InvalidParameterException

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 7/03/12
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
class RomanConverter {

    static final int TOP = 3000

    def sings = [1000:"M",500:"D",100:"C",50:"L",10:"X",5:"V",1:"I"]
    def edgeCases = ["DCCCC":"CM","CCCC":"CD","LXXXX":"XC","XXXX":"XL","VIIII":"IX","IIII":"IV"]

    def romans = []


    String toRoman(Integer number) {
        checkTop(number)
        sings.inject(number) { mod,key,value -> applyRomanSign(mod,key)}

        edgeCases.each { key,value -> checkIfEdgeCase(key)}

        return romans.join("")

    }

    private checkTop(int number) {
        if (number > TOP) {
            throw new InvalidParameterException()
        }
    }

    def checkIfEdgeCase(String currentCase) {
        String romansNumeral = romans.join("")
        if (romansNumeral.contains(currentCase)){
            romansNumeral = romansNumeral.replaceAll(currentCase,edgeCases[currentCase])
        }
        romans = romansNumeral.toList()
    }

    int applyRomanSign(Integer number, int singKey) {
        int divNumberBySingKey = number / singKey
        if (divNumberBySingKey != 0) {
            1.upto(divNumberBySingKey){
                romans << sings[singKey]
            }
        }
        return number % singKey
    }


}
