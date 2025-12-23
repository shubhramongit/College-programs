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
 friend Time operator+(Time,Time);
};

 Time operator+(Time t1,Time t2)
{
  
Time tmp;
  tmp.sec = t1.sec +t2.sec;
  tmp.min=t1.min + t2.min + (tmp.sec/60);
  tmp.hr = t1.hr + t2.hr+(tmp.min/60);
  tmp.sec%=60;
  tmp.min%=60;
 return tmp;

}

int main(){
  Time A1(3,20,31);
  Time A2(3,20,30);
  Time A3;
A3 = A1 + A2;
A1.show();
A2.show();
A3.show();

return 0;
}

