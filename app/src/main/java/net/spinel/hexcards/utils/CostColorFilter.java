package net.spinel.hexcards.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import net.spinel.hexcards.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CostColorFilter {

    private static Pattern colorPattern = Pattern
            .compile("[A-Z]");

    public static SpannableStringBuilder parseFaceByText(Context context,
                                                         String content) {
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        Matcher matcher = colorPattern.matcher(content);
        while (matcher.find()) {
            String ch = matcher.group(0);
            try {
                int res = getImageIds(ch);
                Drawable d = context.getResources().getDrawable(res);
                d.setBounds(0, 0, 45, 45);
                ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BOTTOM);
                builder.setSpan(span, matcher.start(), matcher.end(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } catch (Exception e) {
                // e.printStackTrace();
            }
        }
        return builder;
    }

    private static int getImageIds(String ch) {
        switch (ch.charAt(0)) {
            case 'W':
                return R.drawable.color_white;
            case 'U':
                return R.drawable.color_blue;
            case 'B':
                return R.drawable.color_black;
            case 'R':
                return R.drawable.color_red;
            case 'G':
                return R.drawable.color_green;
        }
        return 0;
    }

}
