package noman.weekcalendar.decorator;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import noman.weekcalendar.R;
import noman.weekcalendar.fragment.WeekFragment;

/**
 * Created by gokhan on 7/27/16.
 */
public class DefaultDayDecorator implements DayDecorator {

    private Context context;
    private final int selectedDateColor;
    private final int todayDateColor;
    private int todayDateTextColor;
    private int textColor;
    private int selectedTextColor;
    private int disableDateTextColor;
    private float textSize;

    public DefaultDayDecorator(Context context,
                               @ColorInt int selectedDateColor,
                               @ColorInt int todayDateColor,
                               @ColorInt int todayDateTextColor,
                               @ColorInt int textColor,
                               @ColorInt int selectedTextColor,
                               float textSize,

                               @ColorInt int disableDateTextColor) {
        this.context = context;
        this.selectedDateColor = selectedDateColor;
        this.todayDateColor = todayDateColor;
        this.todayDateTextColor = todayDateTextColor;
        this.textColor = textColor;
        this.textSize = textSize;
        this.selectedTextColor = selectedTextColor;
        this.disableDateTextColor = disableDateTextColor;
        //this.disableDates = disableDates;
    }

/*    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate(View view, TextView dayTextView,
                         DateTime dateTime, DateTime firstDayOfTheWeek, DateTime selectedDateTime) {

        Drawable holoCircle = ContextCompat.getDrawable(context, R.drawable.holo_circle);
        Drawable solidCircle = ContextCompat.getDrawable(context, R.drawable.solid_circle);

        holoCircle.setColorFilter(selectedDateColor, PorterDuff.Mode.SRC_ATOP);
        solidCircle.setColorFilter(todayDateColor, PorterDuff.Mode.SRC_ATOP);



        if (firstDayOfTheWeek.getMonthOfYear() < dateTime.getMonthOfYear()
                || firstDayOfTheWeek.getYear() < dateTime.getYear())
            dayTextView.setTextColor(Color.GRAY);

        DateTime calendarStartDate = WeekFragment.CalendarStartDate;

        if (dateTime.toLocalDate().equals(calendarStartDate.toLocalDate())) {
            dayTextView.setBackground(solidCircle);
            dayTextView.setTextColor(this.todayDateTextColor);
        } else {
            dayTextView.setTextColor(textColor);
        }

        if (selectedDateTime != null) {
            if (selectedDateTime.toLocalDate().equals(dateTime.toLocalDate())) {
                if (!selectedDateTime.toLocalDate().equals(calendarStartDate.toLocalDate())) {
                    dayTextView.setTextColor(selectedTextColor);
                }

                dayTextView.setBackground(holoCircle);
                dayTextView.setTextColor(selectedTextColor);
            } else {

               //
                dayTextView.setBackground(null);
            }

        }



        float size = textSize;
        if (size == -1)
            size = dayTextView.getTextSize();
        dayTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }*/
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate(View view, TextView dayTextView, DateTime dateTime, DateTime firstDayOfTheWeek, DateTime selectedDateTime, List<LocalDate> disableDates) {
        Drawable holoCircle = ContextCompat.getDrawable(context, R.drawable.holo_circle);
        Drawable solidCircle = ContextCompat.getDrawable(context, R.drawable.solid_circle);

        holoCircle.setColorFilter(selectedDateColor, PorterDuff.Mode.SRC_ATOP);
        solidCircle.setColorFilter(todayDateColor, PorterDuff.Mode.SRC_ATOP);



        if (firstDayOfTheWeek.getMonthOfYear() < dateTime.getMonthOfYear()
                || firstDayOfTheWeek.getYear() < dateTime.getYear())
            dayTextView.setTextColor(Color.GRAY);

        DateTime calendarStartDate = WeekFragment.CalendarStartDate;

        if (dateTime.toLocalDate().equals(calendarStartDate.toLocalDate())) {
            dayTextView.setBackground(solidCircle);
            dayTextView.setTextColor(this.todayDateTextColor);
        } else {
            dayTextView.setTextColor(textColor);
        }
    if (disableDates != null) {
        if (disableDates.contains(dateTime.toLocalDate())) {
            dayTextView.setBackground(null);
            dayTextView.setTextColor(disableDateTextColor);
        }
    }
        if (selectedDateTime != null) {
            if (selectedDateTime.toLocalDate().equals(dateTime.toLocalDate())) {
                if (!selectedDateTime.toLocalDate().equals(calendarStartDate.toLocalDate())) {
                    dayTextView.setTextColor(selectedTextColor);
                }

                dayTextView.setBackground(holoCircle);
                dayTextView.setTextColor(selectedTextColor);
            } else {
                dayTextView.setBackground(null);
            }

        }


        float size = textSize;
        if (size == -1)
            size = dayTextView.getTextSize();
        dayTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }
}
