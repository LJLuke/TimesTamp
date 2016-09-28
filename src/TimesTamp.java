import java.util.Scanner;

/**
 * Created by lijiang on 2016/9/25.
 */
public class TimesTamp {
    public static void main(String[] args){
        System.out.println("请输入数字：");
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();
        CalculateTime calculateTime = new CalculateTime();
        Time time1 = calculateTime.JudgeTime(time);
        long year = time1.getYear();
        long month = time1.getMonth();
        long day = time1.getDay();
        long hour = time1.getHour();
        long minute = time1.getMinute();
        long second = time1.getSecond();
        System.out.println("中时区的时间是：");
        System.out.println(year+"年"+(String.format("%02d",month))+"月" +(String.format("%02d",day))+
                "日 "+(String.format("%02d",hour))+":"+(String.format("%02d",minute))+":"+(String.format("%02d",second)));
        long hour2 = calculateTime.changeTime(hour);
        System.out.println("东八区的时间是：");
        System.out.println(year+"年"+(String.format("%02d",month))+"月" +(String.format("%02d",day))
                +"日 "+(String.format("%02d",hour2))+":"+(String.format("%02d",minute))+":"+(String.format("%02d",second)));
    }
}
