#include<iostream>
#include<string>
using namespace std;

class Employee{
private:
double salary;
int hrs;


void Addsal(){
if(salary<500)
{
salary=salary+1000;

}
}
void Addwork(){
if(hrs>6){
salary=salary+500;
}


}

public :
void getInfo(double,int);
void show();

};
void Employee :: getInfo(double d,int c){
salary=d;
hrs=c;
}
void Employee :: show(){
Addsal();
Addwork();
cout<<"Salary of employee is "<<salary<<endl;
cout<<"hours worked: "<<hrs<<endl;
}


int main(){

Employee e1;
e1.getInfo(400,7);

e1.show();





}

