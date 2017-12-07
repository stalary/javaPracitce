import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {


    public static void main(String[] args) throws Exception {
        String str = "{explanation=我是答案解析-------------, images=[https://oimagec5.ydstatic.com/image?id=-3501435359107303037&product=xue, https://oimagec4.ydstatic.com/image?id=7291802918549390501&product=xue, https://oimagec4.ydstatic.com/image?id=7291802918549390501&product=xue], userScore=3}";
        str = str.substring(1, str.length() - 1);
        String pattern1 = "explanation=(.*?), images=(.*), userScore=(.*)";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }


}

