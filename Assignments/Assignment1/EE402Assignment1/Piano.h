/*
 * Piano.h
 *
 *  Created on: 30 Oct 2018
 *      Author: mlenehan
 */

#ifndef PIANO_H_
#define PIANO_H_

#include <iostream>
#include "Instrument.h"

using std::string;

class Piano: public Instrument {
private:
	static int nextPianoSerialNumber;
	int serialNumber;
	void construct();
protected:
	int noOfKeys;
public:
	Piano();
	Piano(int, string, float, int);
	Piano(string, float, int);
	bool operator < (Piano);
	bool operator == (Piano);
	Piano operator + (Piano);
	virtual void display();
	virtual ~Piano();
};

#endif /* PIANO_H_ */
