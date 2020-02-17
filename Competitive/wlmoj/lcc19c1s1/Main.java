import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int year1=input.nextInt(),month1=input.nextInt(),
            day1=input.nextInt(),duration1=input.nextInt();

        int year2=input.nextInt(),month2=input.nextInt(),
            day2=input.nextInt(),duration2=input.nextInt();

        int tmp;
        if(year2<year1)
        {
            tmp=year1;year1=year2;year2=tmp;
            tmp=month1;month1=month2;month2=tmp;
            tmp=day1;day1=day2;day2=tmp;
        }
        else if(year2==year1)
        {
            if(month2<month1)
            {
                tmp=year1;year1=year2;year2=tmp;
                tmp=month1;month1=month2;month2=tmp;
                tmp=day1;day1=day2;day2=tmp;
            }
            else if(month2==month1)
            {
                if(day2<day1)
                {
                    tmp=year1;year1=year2;year2=tmp;
                    tmp=month1;month1=month2;month2=tmp;
                    tmp=day1;day1=day2;day2=tmp;
                }
                else if(day2==day1)
                {
                    System.out.println("YES");
                }
            }

        }
        for(int loop=1;loop<duration1;++loop)
        {
            ++day1;
            if(month1==1||month1==3||month1==5||month1==7||month1==8||month1==10||month1==12)
            {
                if(day1==32)
                {
                    day1=1;
                    ++month1;
                }
            }
            else if(month1==4||month1==6||month1==9||month1==11)
            {
                if(day1==31)
                {
                    day1=1;
                    ++month1;
                }
            }
            else if(month1==2)
            {
                if(year1%4==0)
                {
                    if(day1==30)
                    {
                        day1=1;
                        ++month1;
                    }
                }
                else
                {
                    if(day1==29)
                    {
                        day1=1;
                        ++month1;
                    }
                }
            }

            if(month1==13)
            {
                ++year1;
                month1=1;
                day1=1;
            }

            if(day1==day2&&month1==month2&&year1==year2)
            {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
