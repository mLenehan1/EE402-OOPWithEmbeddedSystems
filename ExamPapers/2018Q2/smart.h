/*
 * smart.h
 *
 *  Created on: 1 Jan 2019
 *      Author: mlenehan
 */

#include <iostream>
#include <vector>

using std::string;
using std::cout;
using std::endl;
using std::vector;

// Smart Class

#ifndef SMART_H_
#define SMART_H_

class Smart {
protected:
	string identifier, lightType;
public:
	Smart();
	Smart(string iden, string type);
	virtual void turnOn() = 0;
	virtual void turnOff() = 0;
	virtual int getValue() = 0;
	virtual string getLightType() = 0;
	virtual ~Smart();
};

#endif /* SMART_H_ */

// SimpleLight Class

#ifndef SimpleLight_H_
#define SimpleLight_H_

class SimpleLight: public Smart{
private:
	bool status;
public:
	SimpleLight(string iden, bool onOff);
	void turnOn();
	void turnOff();
	int getValue();
	string getLightType();
	string getIden();
	virtual ~SimpleLight();
};

#endif

// DimmableLight Class

#ifndef DimmableLight_H_
#define DimmableLight_H_

class DimmableLight: public Smart{
private:
	int intensity;
public:
	DimmableLight(string iden, int inten);
	void turnOn();
	void turnOff();
	int getValue();
	string getLightType();
	string getIden();
	virtual ~DimmableLight();
};

#endif

// RGBLight Class

#ifndef RGBLight_H_
#define RGBLight_H_

class RGBLight: public Smart{
private:
	int intensityRed, intensityBlue, intensityGreen;
public:
	RGBLight(string iden, int red, int blue, int green);
	void turnOn();
	void turnOff();
	int getValue();
	string getLightType();
	string getIden();
	virtual ~RGBLight();
};

#endif

// LightController Class

#ifndef LightController_H_
#define LightController_H_

class LightController{
private:
	vector<Smart*> vect;
public:
	LightController();
	void addLight(Smart *);
	void display();
};

#endif
