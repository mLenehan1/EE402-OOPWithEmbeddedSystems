/*
 * Guitar.h
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#ifndef GUITAR_H_
#define GUITAR_H_

#include <iostream>
#include "Instrument.h"

using std::string;


class Guitar: public Instrument{
private:
	static int nextGuitarSerialNumber;
	int serialNumber;
	void construct();
protected:
	string bodyShape;
	int noOfStrings;
public:
	Guitar(int, string, float, string, int);
	Guitar(string, float, string, int);
	virtual void display() =0;
	virtual ~Guitar();
};

#endif /* GUITAR_H_ */
