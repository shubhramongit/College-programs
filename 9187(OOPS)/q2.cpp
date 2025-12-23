#include<iostream>
using namespace std;

class Time{
private:
int hr;
int min;
int sec;

public:
Time(){}
Time(int a,int b,int c)
{
 hr=a;
 min=b;
 sec=c;
}
void show(){
  cout<<hr<<":"<<min<<":"<<sec<<endl;
}
Time operator+(Time);
};

Time Time::operator+(Time t)
{
  
Time tmp;
tmp.sec = sec +t.sec;
tmp.min=min + t.min + (tmp.sec/60);
tmp.hr = hr + t.hr+(tmp.min/60);
tmp.sec%=60;
tmp.min%=60;
 return tmp;

}

int main(){
Time t1(3,20,30);
Time t2(3,20,30);
Time t3;
t3 = t1 + t2;
t1.show();
t2.show();
t3.show();

return 0;
}
