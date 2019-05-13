/*
 * Smart.cpp
 *
 *  Created on: 1 Jan 2019
 *      Author: mlenehan
 */

#include "smart.h"

// Smart class methods


Smart::Smart(){
	identifier = "";
	lightType = "";
}

Smart::Smart(string iden, string type) {
	identifier = iden;
	lightType = type;
}

Smart::~Smart() {}

// SimpleLight class methods

SimpleLight::SimpleLight(string iden, bool onOff):
	Smart(iden, "Simple"), status(onOff){}

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
	return Smart::lightType;
}

string SimpleLight::getIden(){
	return identifier;
}

SimpleLight::~SimpleLight(){}

// DimmableLight class methods

DimmableLight::DimmableLight(string iden, int inten):
	Smart(iden, "Dimmable"), intensity(inten){}

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
	return Smart::lightType;
}

string DimmableLight::getIden(){
	return identifier;
}

DimmableLight::~DimmableLight(){}

// RGBLight methods

RGBLight::RGBLight(string iden, int red, int blue, int green):
	Smart(iden, "RGB"), intensityRed(red), intensityBlue(blue), intensityGreen(green){}

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
	return Smart::lightType;
}

string RGBLight::getIden(){
	return identifier;
}

RGBLight::~RGBLight(){}

// LightController Class Methods

LightController::LightController(){

}

// main

int main(){
	SimpleLight simple = SimpleLight("Simple 1", true);
	DimmableLight dim = DimmableLight("Dimmable 1", 255);
	RGBLight rgb = RGBLight("RGB 1", 255, 255, 255);

	cout << "Testing Smart Lighting program" << endl;
	cout << "The " << simple.getLightType() << " light with identifier [" << simple.getIden() << "] has value " << simple.getValue() << endl;
	cout << "The " << dim.getLightType() << " light with identifier [" << dim.getIden() << "] has value " << dim.getValue() << endl;
	cout << "The " << rgb.getLightType()<< " light with identifier [" << rgb.getIden() << "] has value " << rgb.getValue() << endl;
}
