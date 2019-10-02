package com.fun;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilePrinter2 {

    public String encode(final String input) {

        final String regex = "0{3}";
        final String replacement = "00";
        String res = matchAndReplace(input, regex, replacement);

        res = matchAndReplace(res, "1{3}", "1");

        res = matchAndReplace(res, "10", "1");

        return res;
    }

    private String matchAndReplace(final String input, final String regex, final String replacement) {
        final Pattern rule = Pattern.compile(regex);

        String res = input;
        Matcher matcher = rule.matcher(input);
        while (matcher.find()) {
            String tmp = matcher.replaceAll(replacement);
            matcher = rule.matcher(tmp);
            res = tmp;
        }
        return res;

    }
}
