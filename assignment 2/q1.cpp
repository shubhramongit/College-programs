#include <iostream>
#include<string>
using namespace std;

class Bankacc{
private:
  string name;
  int accno;
  string type;
  double amount;
public:
  void input(string,int,string,double);
  void deposit(double);
  void withdraw(double);
  void display();
};
void Bankacc :: input(string a,int b,string c, double d){  
   name=a;
   accno=b;
   type=c;
   amount=d;
}
void Bankacc :: deposit(double dep){
 amount=amount+dep;
}
void Bankacc:: withdraw(double with){
 if(with<=amount){
 amount=amount-with;
}
else{
 cout<<"Insufficient balance";
}
}
  void Bankacc :: display(){
  cout<< "Account Holder: "+name<<endl;
  cout<<"Balance : "<<amount;
 }
 int main(){
 Bankacc a1;
 a1.input("Suvam",1234,"saving",310000);
 a1.deposit(80000);
 a1.withdraw(300000);
 a1.display();
 return 0;
 }
