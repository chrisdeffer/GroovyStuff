/**
 * Created by chris on 3/11/2017.
 */
class Transformation {
    def value
    def input, output
    double convert
    def map =
            [ "lbs" : "weight",
              "feet" : "len",
              "meter": "len",
              "inch" : "len",
              "ounce" : "weight",
              "pint" : "vol",
              "fluid ounce" : "vol",
              "kg": "weight"
            ]
    def result

    def getThis = { this }


    }
    def convert(value) {
        this.value = value
        if(value=~/^[0-9]+\.[0-9]+$/) {
           convert = Float.parseFloat(value.toString())
        } else {
            println "You must enter a decimal number to run the conversion"
            exit(1)
        }

        this
    }
    def from(input) {
        this.input = input
        this
    }
    def to(output) {
        this.output = output
       this
    }
    def calculationConvertException() {

        throw new Exception("cannot convert from "+map[input]+ " to "+ map[output]);
    }
    def go() {
        def value1 = map[output] ?: "default"
        def value2 = map[input] ?: "default"

        if(!value1.equals(value2))
            calculationConvertException()

        switch(value1) {
            case "weight":
                if (input.equals("lbs") && output.equals("kg")) {
                    result = convert / 2.20
                    println "Result is: "
                    printf("%.2f", result);
                    println " kgs"
                } else if (input.equals("ounce") && output.equals("kg")) {
                    result = convert / 35.2
                    pprintln "Result is: "
                    printf("%.2f", result);
                    println " kgs"
                } else if (input.equals("kg") && output.equals("ounce")) {
                    result = convert * 35.2
                    println "Result is: "
                    printf("%.2f", result);
                    println " ounces"
                } else if (input.equals("lbs") && output.equals("ounce")) {
                    result = 16 * convert
                    println "Result is: "
                    printf("%.2f", result);
                    println " ounces"
                } else if (input.equals("ounce") && output.equals("lbs")) {
                    result = convert / 16
                    println "Result is: "
                    printf("%.2f", result);
                    println " lbs"
                } else if (input.equals("kg") && output.equals("lbs")) {
                    result = convert * 2.20
                    println "Result is: "
                    printf("%.2f", result);
                    println " lbs"
                } else {
                    println "Unknown"

                }
                break
            case "vol":
                if (input.equals("pint") && output.equals("fluid ounce"))  {
                    result = 16 * convert
                    println "Result is: "
                    printf("%.2f", result);
                    println " ounces"
                } else {
                    result = convert / 16
                    println "Result is: "
                    printf("%.2f", result);
                    println " pints"
                }
                break
            case "len":
                if(input.equals("inch") && output.equals("meter")) {
                    result = 0.0254 * convert
                    println "Result is: "
                    printf("%.2f", result);
                    println " meters"
                } else if (input.equals("meter") && output.equals("inch")) {
                    result = convert / 0.0254
                    println "Result is: "
                    printf("%.2f", result);
                    println " inches"
                } else if (input.equals("feet") && output.equals("inch"))  {
                    result = convert * 12
                    println "Result is: "
                    printf("%.2f", result);
                    println " inches"
                } else if (input.equals("meter") && output.equals("feet"))  {
                    result = convert * 3.28
                    println "Result is: "
                    printf("%.2f", result);
                    println " feet"
                } else if (input.equals("inch") && output.equals("feet"))  {
                    result = convert / 12
                    println "Result is: "
                    printf("%.2f", result);
                    println " feet"
                }  else if (input.equals("feet") && output.equals("meter")) {
                    result = convert / 3.28
                    println "Result is: "
                    printf("%.2f", result);
                    println " meters"
                } else if (input.equals("inch") && output.equals("meter"))  {
                    result = convert * 0.0254
                    println "Result is: "
                    printf("%.2f", result);
                    println " meters"
                } else {
                    println "Unknown"
                }
                break
            default:
                println "no such value"
        }
        this
    }

}

class ConversionsMap
{
    String mesureation = null
    String measure_type = null
    static double conversion = 0.0

    map convert_type = ["lbs2kgs": ]

}


def measurement = new Transformation()
/*
*  Valid inputs:
 * inch, meter, feet, fluid ounce, ounce, kg, lbs
*/
//measurement.convert("24.0").from("inch").to("meter").go()

println "${measurement.getThis()}"