/*
 * Instrument.h
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#ifndef INSTRUMENT_H_
#define INSTRUMENT_H_

#include<iostream>

using std::string;

class Instrument {
private:
	friend void salePrice(Instrument &, float);
protected:
	string manufacturer;
	float price;
	Instrument();
	Instrument(string, float);
	virtual void display() = 0;
	virtual ~Instrument();
};

#endif /* INSTRUMENT_H_ */
