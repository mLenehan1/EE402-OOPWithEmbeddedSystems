/*
 * ElectroAcousticGuitar.cpp
 *
 *  Created on: 30 Oct 2018
 *      Author: mlenehan
 */

#include <iostream>
#include "ElectroAcousticGuitar.h"

using namespace std;

ElectroAcousticGuitar::ElectroAcousticGuitar(int aSerialNumber, string aManufacturer, float aPrice, string aBodyShape,
		int numStrings, int numSoundholes, int numPickups, string typePickup) :
				AcousticGuitar(aSerialNumber, aManufacturer, aPrice, aBodyShape, numStrings, numSoundholes),
				ElectricGuitar(aSerialNumber, aManufacturer, aPrice, aBodyShape, numStrings, numPickups, typePickup),
				Guitar(aSerialNumber, aManufacturer, aPrice, aBodyShape, numStrings){
}

ElectroAcousticGuitar::ElectroAcousticGuitar(string aManufacturer, float aPrice, string aBodyShape,
		int numStrings, int numSoundholes, int numPickups, string typePickup) :
				AcousticGuitar(aManufacturer, aPrice, aBodyShape, numStrings, numSoundholes),
				ElectricGuitar(aManufacturer, aPrice, aBodyShape, numStrings, numPickups, typePickup),
				Guitar(aManufacturer, aPrice, aBodyShape, numStrings){
}

ElectroAcousticGuitar::~ElectroAcousticGuitar() {
	cout << "Destructor Output: " << endl;
	cout << "ElectroAcoustic Destroyed" << endl;
	cout << "Guitar had the following details:" << endl;
	this->display();
}

void ElectroAcousticGuitar::display(){
	cout << "Display Function Output: " << endl;
	this->AcousticGuitar::display();
	cout << "Number of Pickups: " << this->ElectricGuitar::noOfPickups << "." << endl;
	cout << "Pickup Type: " << this->ElectricGuitar::pickupType << "." << endl;
}

