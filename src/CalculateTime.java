/**
 * Created by lijiang on 2016/9/25.
 */
public class CalculateTime {
    final int minute = 60;
    final int hour = minute * 60;
    final int day = hour * 24;
    final int year = day * 365;
    final int leapYear = 3 * year + day * 366;
    final int month[] = {30 * day,28 * day,31 * day,30 * day,31 * day,30 *day,31 * day,
            31 * day,30 * day,31 * day,30 * day,31 * day};
    final int leapMonth[] = {30 * day,29 * day,31 * day,30 * day,31 * day,30 *day,31 * day,
            31 * day,30 * day,31 * day,30 * day,31 * day};
    Time mTime = new Time();

    public Time JudgeTime(long time) {
        long mLeapYear = time / leapYear;
        time = time - mLeapYear * leapYear;
        long mYear = time / year;
        time = time - mYear * year;
        long year = mLeapYear * 4 + mYear + 1970;
        mTime.setYear(year);

        int monthArr[] = isLeapYear(year) ? leapMonth : month;
        int month = 1;
        for (int i=0;i<monthArr.length;i++){
            if (time - monthArr[i] < 0)
                break;
            ++month;
            time = time - monthArr[i];
        }
        mTime.setMonth(month);

        long mDay = 0;
        if (time % day == 0){
            mDay = time / day;
            time = time - mDay * day;
            mTime.setDay(mDay);
        }else {
            mDay = time / day;
            time = time - mDay * day;
            mTime.setDay(mDay+1);
        }


        long mHour = time / hour;
        time = time - hour * mHour;
        mTime.setHour(mHour);

        long mMinute = time / minute;
        time = time - mMinute * minute;
        mTime.setMinute(mMinute);

        mTime.setSecond(time);
        return mTime;
    }
    public boolean isLeapYear(long year){
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 )
            return true;
        else
            return false;
    }
    public long changeTime(long hour){
        hour = hour + 8;
        return hour;
    }
}
