/*
 * SmartLight.h
 *
 *  Created on: 6 Jan 2019
 *      Author: mlenehan
 */

#ifndef SMARTLIGHT_H_
#define SMARTLIGHT_H_

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

namespace smart {

class SmartLight{
protected:
	string identifier;
	friend ostream & operator << ( ostream &stream, SmartLight *s);
public:
	SmartLight(string);
	virtual void turnOn()=0;
	virtual void turnOff()=0;
	virtual int getValue()=0;
	virtual string getIdentifier() {return identifier;}
	virtual ~SmartLight();
	bool operator < (const SmartLight& s) const{
		return (identifier < s.identifier ? true : false);}
	bool operator > (const SmartLight& s) const{
		return (identifier > s.identifier ? true : false);}
};

class SimpleLight: public SmartLight{
private:
	bool onoff;
public:
	SimpleLight(string);
	void turnOn() {onoff = true;}
	void turnOff() {onoff = false;}
	int getValue() {return (int)onoff;}
	string getLightType() {return "SimpleLight";}
};

class DimmableLight: public SmartLight{
private:
	int intensity;
public:
	DimmableLight(string);
	void turnOn() {intensity = 255;}
	void turnOff() {intensity = 0;}
	int getValue() {return intensity;}
	string getLightType() {return "DimmableLight";}
};

class RGBLight: public SmartLight{
private:
	int red, green, blue;
public:
	RGBLight(string);
	void turnOn() {red = 255; green = 255; blue = 255;}
	void turnOff() { red = 0; green = 0; blue = 0;}
	int getValue() {return (red+green+blue)/3;}
	string getLightType() {return "RGBLight";}
};

class LightController{
private:
	std::vector<SmartLight *> lights;
public:
	LightController();
	virtual void addLight(SmartLight *);
	virtual void display();
	virtual ~LightController() {}
};

} /* namespace smart */

#endif /* SMARTLIGHT_H_ */
