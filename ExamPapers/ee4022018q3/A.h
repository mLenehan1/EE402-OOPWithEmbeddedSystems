/*
 * A.h
 *
 *  Created on: 6 Jan 2019
 *      Author: mlenehan
 */

#ifndef A_H_
#define A_H_

#include <iostream>

using namespace std;

class A {
public:
	virtual void display() {cout << "Class A" << endl;}
	virtual ~A() {}
};

class AA: public A{
public:
	virtual void display() {cout << "Class AA" << endl;}
	virtual ~AA() {}
};

#endif /* A_H_ */
