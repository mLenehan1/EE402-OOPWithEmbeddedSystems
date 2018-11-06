/*
 * ElectricGuitar.h
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#ifndef ELECTRICGUITAR_H_
#define ELECTRICGUITAR_H_

#include <iostream>
#include "Guitar.h"

using std::string;

class ElectricGuitar: public virtual Guitar {
private:
protected:
	int noOfPickups;
	string pickupType;
public:
	ElectricGuitar(int, string, float, string, int, int, string);
	ElectricGuitar(string, float, string, int, int, string);
	void display();
	virtual ~ElectricGuitar();
};

#endif /* ELECTRICGUITAR_H_ */
