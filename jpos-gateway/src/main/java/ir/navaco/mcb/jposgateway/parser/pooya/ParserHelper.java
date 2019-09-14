package ir.navaco.mcb.jposgateway.parser.pooya;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

@Component
public class ParserHelper {
    public static Date parseDate(String field, String format) throws ParseException {
        if(field instanceof String) {
            String thisYear = Year.now().toString();
            if(format.contains("Y") || format.contains("D")) {
                throw new ParseException("please use yy|yyyy for year and dd for day", 0);
            }

            if(format.contains("yy") && !format.contains("yyyy")) {
                format = "yy" + format;
                field = thisYear.substring(0, 2) + field;
            }else if(!format.contains("yyyy")) {
                format = "yyyy" + format;
                field = thisYear + field;
            }

            SimpleDateFormat originalFormat = new SimpleDateFormat(format);
            return originalFormat.parse(field);
        }
        return null;
    }
}
