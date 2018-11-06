/*
 * Instrument.cpp
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#include <iostream>
#include "Instrument.h"
using namespace std;

Instrument::Instrument(){
}

Instrument::Instrument(string aManufacturer, float aPrice) : manufacturer(aManufacturer), price(aPrice) {
}

Instrument::~Instrument() {
}

void Instrument::display(){
	cout << "Manufacturer: " << this->manufacturer << "." << endl;
	cout << "Price: " << this->price << "." << endl;
}

