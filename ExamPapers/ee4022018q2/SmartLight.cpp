/*
 * SmartLight.cpp
 *
 *  Created on: 6 Jan 2019
 *      Author: mlenehan
 */

#include "SmartLight.h"

namespace smart {

SmartLight::SmartLight(string identifier) : identifier(identifier) {}

ostream & operator<< (ostream &stream, SmartLight *s){
	stream << "{ Light:\"" << s->getIdentifier() << "\" state: \"" << s->getValue() << "\" }";
	return stream;
}

SmartLight::~SmartLight() {}

SimpleLight::SimpleLight(string identifier) : SmartLight(identifier), onoff(false){}

DimmableLight::DimmableLight(string identifier) : SmartLight(identifier), intensity(0){}

RGBLight::RGBLight(string identifier) : SmartLight(identifier), red(0), green(0), blue(0){}

LightController::LightController(){
	lights = vector<SmartLight *>();
}

void LightController::addLight(SmartLight* light){
	lights.push_back(light);
}

void output(smart::SmartLight * light){
	//cout << "Lights: " << light->getIdentifier() << endl;
	cout << light << endl;
}

bool comparePtrToSmartLights(SmartLight* a, SmartLight* b) {return (*a < *b);}

void LightController::display(){
	sort(lights.begin(), lights.end(), comparePtrToSmartLights);
	for_each(lights.begin(), lights.end(), output);
}

} /* namespace smart */

int main(){
	smart::LightController lc;
	cout << "Testing Smart Lighting Program" << endl;
	smart::SimpleLight simple("Simple 1");
	simple.turnOn();
	smart::DimmableLight dimmable("Dimmable 1");
	dimmable.turnOn();
	smart::RGBLight rgb("RGB 1");
	rgb.turnOn();
	cout << "The Simple Light with identifier [" << simple.getIdentifier() << "] has value " << simple.getValue() << endl;
	cout << "The Dimmable Light with identifier [" << dimmable.getIdentifier() << "] has value " << dimmable.getValue() << endl;
	cout << "The RGB Light with identifier [" << rgb.getIdentifier() << "] has value " << rgb.getValue() << endl;
	lc.addLight(&simple);
	lc.addLight(&dimmable);
	lc.addLight(&rgb);
	lc.display();
}
