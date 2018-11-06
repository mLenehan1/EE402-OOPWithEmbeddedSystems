/*
 * ElectricGuitar.cpp
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#include "ElectricGuitar.h"

using namespace std;

ElectricGuitar::ElectricGuitar(int aSerialNumber, string aManufacturer,
		float aPrice, string aBodyShape, int numStrings, int numPickups,
		string typePickup) :
		Guitar(aSerialNumber, aManufacturer, aPrice, aBodyShape, numStrings), noOfPickups(
				numPickups), pickupType(typePickup) {
}

ElectricGuitar::ElectricGuitar(string aManufacturer, float aPrice, string aBodyShape, int numStrings, int numPickups, string typePickup) :
		Guitar(aManufacturer, aPrice, aBodyShape, numStrings), noOfPickups(numPickups), pickupType(typePickup){
}

ElectricGuitar::~ElectricGuitar() {
	cout << "Electric Guitar Destroyed" << endl;
}

void ElectricGuitar::display() {
	this->Guitar::display();
	cout << "Number of Pickups: " << this->noOfPickups << "." << endl;
	cout << "Pickup Type: " << this->pickupType << "." << endl;
}
