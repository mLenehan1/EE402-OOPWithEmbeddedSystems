/*
 * AcousticPiano.cpp
 *
 *  Created on: 30 Oct 2018
 *      Author: mlenehan
 */

#include <iostream>
#include "AcousticPiano.h"

using namespace std;

AcousticPiano::AcousticPiano(int aSerialNumber, string aManufacturer, float aPrice, int numKeys, string aPianoShape) :
	Piano(aSerialNumber, aManufacturer, aPrice, numKeys), pianoShape(aPianoShape){
}

AcousticPiano::AcousticPiano(string aManufacturer, float aPrice, int numKeys, string aPianoShape) :
	Piano(aManufacturer, aPrice, numKeys), pianoShape(aPianoShape){
}

AcousticPiano::AcousticPiano(const AcousticPiano &sourcePiano) :
	AcousticPiano("Copy", 0, 60, "Upright"){
	cout << "Copy Created" << endl;
}

AcousticPiano::~AcousticPiano() {
	cout << "Acoustic Piano Destroyed" << endl;
}

void AcousticPiano::display(){
	this->Piano::display();
	cout << "Piano Shape: " << this->pianoShape << "." << endl;
}
