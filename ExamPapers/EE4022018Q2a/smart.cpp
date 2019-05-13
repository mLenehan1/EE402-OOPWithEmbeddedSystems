/*
 * smart.cpp
 *
 *  Created on: 1 Jan 2019
 *      Author: mlenehan
 */

#include <iostream>
#include "smart.h"

using std::cout;
using std::endl;

// smart class methods

smart::smart(string iden, string type) {
	identifier = iden;
	lightType = type;
}

void smart::display(){
}

smart::~smart() {
	cout << "Light Removed" << endl;
}

// SimpleLight class methods

SimpleLight::SimpleLight(string iden, bool onOff):
	smart(iden, "Simple"), status(onOff){}

void SimpleLight::turnOn(){
	status = true;
}

void SimpleLight::turnOff(){
	status =false;
}

int SimpleLight::getValue(){
	return status;
}

string SimpleLight::getLightType(){
	return smart::lightType;
}

// DimmableLight class methods

DimmableLight::DimmableLight(string iden, int inten):
	smart(iden, "Dimmable"), intensity(inten){}

void DimmableLight::turnOn(){
	intensity = 255;
}

void DimmableLight::turnOff(){
	intensity = 0;
}

int DimmableLight::getValue(){
	return intensity;
}

string DimmableLight::getLightType(){
	return smart::lightType;
}
// RGBLight methods

RGBLight::RGBLight(string iden, int red, int blue, int green):
	smart(iden, "RGB"), intensityRed(red), intensityBlue(blue), intensityGreen(green){}

void RGBLight::turnOn(){
	intensityRed = 255;
	intensityBlue = 255;
	intensityGreen = 255;
}

void RGBLight::turnOff(){
	intensityRed = 0;
	intensityBlue = 0;
	intensityGreen = 0;;
}

int RGBLight::getValue(){
	return (intensityRed+intensityBlue+intensityGreen)/3;
}

string RGBLight::getLightType(){
	return smart::lightType;
}
// main

int main(){
	SimpleLight test = SimpleLight("Simple1", false);
	test.turnOn();
	cout << test.getValue() << endl;
}
