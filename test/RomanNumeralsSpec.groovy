import spock.lang.Specification
import org.kataingles.RomanConverter
import spock.lang.Unroll
import java.security.InvalidParameterException
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 7/03/12
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
class RomanNumeralsSpec extends Specification{

    RomanConverter converter
    String roman

    def setup(){
        converter = new RomanConverter()
    }

    @Unroll
    def "it should return roman when is number"(){
    
        expect: a == converter.toRoman(b)
        
        where: a   | b
               "I" | 1
              "II" | 2
             "III" | 3
               "V" | 5
              "VI" | 6
              "IV" | 4
              "X"  | 10
              "XI" | 11
              "IX" | 9
              "L"  | 50
              "XLV"| 45
              "C"  | 100
              "XC" | 90
           "CCXXI" | 221
              "D"  | 500
          "CDLVII" | 457
      "DCCLXXXVII" | 787
               "M" | 1000
          "CMXLII" | 942
        "MMDCXXII" | 2622
         "MCMXCIX" | 1999
    }

    def "it throw a exception when the number is higher than 3000"(){

        when: converter.toRoman(3001)

        then: thrown(InvalidParameterException.class)

    }


}
