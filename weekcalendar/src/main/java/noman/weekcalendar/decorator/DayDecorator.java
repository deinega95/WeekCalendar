package noman.weekcalendar.decorator;

import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by gokhan on 7/27/16.
 */
public interface DayDecorator {
   // void decorate(View view, TextView dayTextView, DateTime dateTime, DateTime firstDayOfTheWeek, DateTime selectedDateTime);
    void decorate(View view, TextView dayTextView, DateTime dateTime, DateTime firstDayOfTheWeek, DateTime selectedDateTime, List<LocalDate> disableDates);
}
