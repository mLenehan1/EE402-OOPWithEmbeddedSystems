/*
 * smart.h
 *
 *  Created on: 1 Jan 2019
 *      Author: mlenehan
 */

// Smart Class

#ifndef SMART_H_
#define SMART_H_

#include <iostream>

using std::string;

class smart {
protected:
	string identifier, lightType;
public:
	smart(string iden, string type);
	virtual void turnOn();
	virtual void turnOff();
	virtual int getValue() = 0;
	virtual string getLightType() = 0;
	void display();
	virtual ~smart();
};

#endif /* SMART_H_ */

// SimpleLight Class

#ifndef SimpleLight_H_
#define SimpleLight_H_

#include <iostream>

using std::string;

class SimpleLight: public smart{
private:
	bool status;
public:
	SimpleLight(string iden, bool onOff);
	void turnOn();
	void turnOff();
	int getValue();
	string getLightType();
};

#endif

// DimmableLight Class

#ifndef DimmableLight_H_
#define DimmableLight_H_

#include <iostream>

using std::string;

class DimmableLight: public smart{
private:
	int intensity;
public:
	DimmableLight(string iden, int inten);
	void turnOn();
	void turnOff();
	int getValue();
	string getLightType();
};

#endif

// RGBLight Class

#ifndef RGBLight_H_
#define RGBLight_H_

#include <iostream>

using std::string;

class RGBLight: public smart{
private:
	int intensityRed, intensityBlue, intensityGreen;
public:
	RGBLight(string iden, int red, int blue, int green);
	void turnOn();
	void turnOff();
	int getValue();
	string getLightType();
};

#endif
