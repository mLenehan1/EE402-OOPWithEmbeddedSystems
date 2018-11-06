/*
 * AcousticGuitar.cpp
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#include "AcousticGuitar.h"

using namespace std;

AcousticGuitar::AcousticGuitar(int aSerialNumber, string aManufacturer,
		float aPrice, string aBodyShape, int numStrings, int numSoundholes):
		Guitar(aSerialNumber, aManufacturer, aPrice, aBodyShape, numStrings), noOfSoundholes(numSoundholes){
}

AcousticGuitar::AcousticGuitar(string aManufacturer, float aPrice, string aBodyShape, int numStrings, int numSoundholes) :
		Guitar(aManufacturer, aPrice, aBodyShape, numStrings), noOfSoundholes(numSoundholes){
}

AcousticGuitar::~AcousticGuitar() {
	cout << "Acoustic Guitar Destroyed" << endl;
}

void AcousticGuitar::display() {
	this->Guitar::display();
	cout << "Number of Soundholes: " << this->noOfSoundholes << "." << endl;
}

