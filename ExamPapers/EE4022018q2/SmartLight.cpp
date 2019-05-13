/*
 * SmartLight.cpp
 *
 *  Created on: 6 Jan 2019
 *      Author: mlenehan
 */

#include <iostream>
#include <string>

using namespace std;

namespace smart {

class SmartLight{
protected:
	string identifier;
public:
	SmartLight(string);
	virtual void turnOn()=0;
	virtual void turnOff()=0;
	virtual int getValue()=0;
	virtual string getLightType() {return identifier};
	
};

SmartLight::SmartLight(string identifier) : identifier(identifier){}

class SimpleLight: public SmartLight{
private:
	bool onoff;
public:
	void turn on();
	void turn off();
	int getValue();
	string getLightType();
};



}
