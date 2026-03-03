#include <iostream>

using namespace std;

void getEmployeeInfo(long empId[], int hours[], double payRate[], double wages[], int x){
  for (int i = 0; i < x; i++){
    cout << "Employee #" << empId[i] << endl;

    cout << "Enter hours worked: ";
    cin >> hours[i];

    cout << "Enter employee pay rate: ";
    cin >> payRate[i];
  }
  for (int i = 0; i <x; i++) {
    wages[i] = hours[i] * payRate[i];
  }
}
void displayWages(long empId[], double wages[], int x){
  for (int i = 0; i < x; i++) {
    cout << "Employee #" << empId[i] << " has a wage of $" << wages[i] << endl;
  }
}

int main() {

  long empId[7] = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};

  int hours[7];

  double payRate[7];

  double wages[7];

  getEmployeeInfo(empId, hours, payRate, wages, 7);
  displayWages(empId, wages, 7);
}
