package com.fun;

@Deprecated
public class FilePrinter {

    public String encode(final String input) {
        StringBuffer stringBuffer = new StringBuffer(3);
        StringBuilder builder = new StringBuilder(input.length());

        for (char c : input.toCharArray()) {
            stringBuffer.append(c);

            if (stringBuffer.length() < 3) continue;

            final String tempsRes = stringBuffer.toString();
            if (tempsRes.equals("000")) {
                stringBuffer.replace(0, 3, "00");
                continue;
            }
            if (tempsRes.equals("001")) {
                builder.append(stringBuffer.substring(0, 2));
                stringBuffer.delete(0, 2);
            }

            if(tempsRes.equals("010")) {
                builder.append(stringBuffer.substring(0, 2));
                stringBuffer.delete(0, 2);
            }

            if(tempsRes.equals("100")) {
                builder.append(stringBuffer.substring(0, 1));
                stringBuffer.delete(0, 1);
            }

            if(tempsRes.equals("011")) {
                builder.append(stringBuffer.substring(0, 1));
                stringBuffer.delete(0, 1);
            }

            if(tempsRes.equals("110")) {
                builder.append(stringBuffer.substring(0, 2));
                stringBuffer.delete(0, 2);
            }
            if (tempsRes.equals("111")) {
                stringBuffer.replace(0, 3, "1");
            }
        }
        builder.append(stringBuffer);
        final String firstEncoded = builder.toString();

        stringBuffer = new StringBuffer(2);
        builder = new StringBuilder(firstEncoded.length());

        for (char c : firstEncoded.toCharArray()) {
            stringBuffer.append(c);
            if (stringBuffer.length() < 2) continue;
            final String s = stringBuffer.toString();
            if (s.equals("10")) {
                stringBuffer.replace(0, 2, "1");
            }
            if (s.equals("00")) {
                builder.append(s);
                stringBuffer.delete(0, 2);
            }
            if (s.equals("01")) {
                builder.append("0");
                stringBuffer.delete(0, 1);
            }
            if (s.equals("11")) {
                builder.append("1");
                stringBuffer.delete(0, 1);
            }
        }
        builder.append(stringBuffer);
        return builder.toString();
    }
}
