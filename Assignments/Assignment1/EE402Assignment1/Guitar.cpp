/*
 * Guitar.cpp
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#include <iostream>
#include "Guitar.h"

using namespace std;

Guitar::Guitar(int aSerialNumber, string aManufacturer, float aPrice,
		string aBodyShape, int numStrings) :
		Instrument(aManufacturer, aPrice), serialNumber(aSerialNumber), bodyShape(aBodyShape), noOfStrings(numStrings) {
}

Guitar::Guitar(string aManufacturer, float aPrice, string aBodyShape, int numStrings) :
		Instrument(aManufacturer, aPrice), bodyShape(aBodyShape), noOfStrings(numStrings) {
	construct();
}

Guitar::~Guitar() {
}

int Guitar::nextGuitarSerialNumber = 0001;

void Guitar::display() {
	this->Instrument::display();
	cout << "Material: " << this->bodyShape << "." << endl;
	cout << "Number of Strings: " << this->noOfStrings << "." << endl;
	cout << "Serial Number: " << this->serialNumber <<"." << endl;
}

void Guitar::construct(){
	serialNumber = nextGuitarSerialNumber++;
}
