/*
 * Piano.cpp
 *
 *  Created on: 30 Oct 2018
 *      Author: mlenehan
 */

#include <iostream>
#include <string>
#include "Piano.h"

using namespace std;

Piano::Piano(){
}

Piano::Piano(int aSerialNumber, string aManufacturer, float aPrice, int numKeys) :
	Instrument(aManufacturer, aPrice), serialNumber(aSerialNumber), noOfKeys(numKeys){
}

Piano::Piano(string aManufacturer, float aPrice, int numKeys) :
		Instrument(aManufacturer, aPrice), noOfKeys(numKeys){
	construct();
}

Piano::~Piano() {
}

int Piano::nextPianoSerialNumber = 1001;

void Piano::display(){
	this->Instrument::display();
	cout << "Number of Keys: " << this->noOfKeys << "." << endl;
	cout << "Serial Number: " << this->serialNumber << "." << endl;
}

void Piano::construct(){
	serialNumber = nextPianoSerialNumber++;
}

Piano Piano::operator +(Piano inPiano) {
	return Piano(inPiano.manufacturer+manufacturer, inPiano.price+price, noOfKeys+inPiano.noOfKeys);
}

bool Piano::operator <(Piano inPiano){
	return (serialNumber<inPiano.serialNumber? true:false);
}

bool Piano::operator ==(Piano inPiano){
	if((inPiano.serialNumber == serialNumber) && (inPiano.manufacturer == manufacturer)
			&& (inPiano.price == price) && (inPiano.noOfKeys == noOfKeys)){
		return true;
	}
	else return false;
}
