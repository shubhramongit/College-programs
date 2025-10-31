#include<iostream>
#include<string>
using namespace std;

class Account{
private:
  string name;
  int accno;
  string type;
  double amount;
public:
  void input();
  void deposit();
  void withdraw();
  void display();
};

 void Account :: input()
{
cout<<"ENter the name of depositor"<<endl;
cin>>name;
cout<<"Enter the account_no"<<endl;
cin>>accno;
cout<<"Enter the type of account"<<endl;
cin>>type;
cout<<"Enter the account balalnce" <<endl;
cin>>amount;
}

void Account :: deposit()
{
double dep;
cout<<"Enter the amount to be deposited"<<endl;
cin>>dep;
amount=amount+dep;
}

void Account :: withdraw()
{
double with;
cout<<"ENter the amount to be withdrawn"<<endl;
cin>>with;

if(with<=amount)
{
amount=amount-with;
}
else{
cout<<"insufficient balalnce";
}
}
void Account :: display(){
cout<<"Account Holder: "+name<<endl;
cout<<"balance : "<<amount;
}
 int main(){
 
 Account a1[100];
 int n=2;
 for(int i=0;i<n;i++)
 {
 cout<<"ENter data for emp no "<<(i+1)<<endl;
 a1[i].input();
 a1[i].deposit();
 a1[i].withdraw();
 }
 
 
 for(int i=0;i<n;i++)
 {
 cout<<" Details for emp no "<<(i+1)<<endl;
 a1[i].display();
 }

 return 0;

 }
