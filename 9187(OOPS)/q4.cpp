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
void operator--();
void operator--(int);

};
void Time::operator--()
{
if(hr>0&&min>0)
{
 hr=hr-1;
 min=min-1;
}
else{
  min=59;
  sec=59;
  hr=hr-1;
}
}
void Time::operator--(int)
{
if(hr>0||min>0)
{
 hr=hr-1;
 min=min-1;
}
else{
  min=59;
  sec=59;
  hr=hr-1;
}
}
int main()
{
Time t1(0,1,59);
Time t2(1,0,30);
--t1;
t2--;
t1.show();
t2.show();

return 0;
}


return 0;
}
