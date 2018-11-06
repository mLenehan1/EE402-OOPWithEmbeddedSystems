/*
 * ElectroAcousticGuitar.h
 *
 *  Created on: 30 Oct 2018
 *      Author: mlenehan
 */

#ifndef ELECTROACOUSTICGUITAR_H_
#define ELECTROACOUSTICGUITAR_H_

#include <iostream>
#include "AcousticGuitar.h"
#include "ElectricGuitar.h"

using std::string;

class ElectroAcousticGuitar: public AcousticGuitar, public ElectricGuitar {
public:
	ElectroAcousticGuitar(int, string, float, string, int, int, int, string);
	ElectroAcousticGuitar(string, float, string, int, int, int, string);
	void display();
	virtual ~ElectroAcousticGuitar();
};

#endif /* ELECTROACOUSTICGUITAR_H_ */
